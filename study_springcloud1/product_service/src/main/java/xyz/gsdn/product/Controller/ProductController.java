package xyz.gsdn.product.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import xyz.gsdn.product.entity.Product;
import xyz.gsdn.product.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

//    @Autowired
//    DiscoveryClient discoveryClient;

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Product findById(@PathVariable(value = "id") Long id)
    {

        Product product = productService.findById(id);
        System.out.println(product);
        return product;
    }


//    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
//    public Product findById(@PathVariable(value = "id") Long id)
//    {
//        discoveryClient.getInstances("ser")
//        Product product = productService.findById(id);
//        System.out.println(product);
//        return product;
//    }


}
