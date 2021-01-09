package xyz.gsdn.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.gsdn.product.dao.ProductDao;
import xyz.gsdn.product.entity.Product;

@Service
public class ProductService {

    @Autowired
    ProductDao productDao;

   public Product findById(Long id)
    {
        return productDao.findById(id).get();
    }

    public void save(Product product)
    {
        productDao.save(product);
    }

    public  void delete(Long id){

        productDao.deleteById(id);
    }

    public  void update(Product product)
    {
        productDao.save(product);
    }

}
