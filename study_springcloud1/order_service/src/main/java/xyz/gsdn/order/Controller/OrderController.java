package xyz.gsdn.order.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import xyz.gsdn.order.entity.Product;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    DiscoveryClient discoveryClient;
    
    @Autowired
    RestTemplate restTemplate;

//    @RequestMapping(value = "/buy/{id}",method = RequestMethod.GET)
//    public Product findById(@PathVariable(value = "id") Long id)
//    {
//        Product product = restTemplate.getForObject("http://localhost:9004/product/"+id, Product.class);
//        System.out.println(product);
//        return product;
//    }


    @RequestMapping(value = "/buy/{id}",method = RequestMethod.GET)
    public Product findById(@PathVariable(value = "id") Long id)
    {
        List<ServiceInstance> instances = discoveryClient.getInstances("service-product");
        for (ServiceInstance instance : instances) {
            System.out.println(instance);
        }
        ServiceInstance serviceInstance = instances.get(0);
        String host = serviceInstance.getHost();
        int port = serviceInstance.getPort();
        String url = "http://"+host+":"+port+"/product/"+id;
        System.out.println(url);
        Product product = restTemplate.getForObject(url, Product.class);
        System.out.println(product);
        return product;
    }
}
