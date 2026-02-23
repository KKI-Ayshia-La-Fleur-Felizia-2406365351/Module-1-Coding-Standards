package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.ProductRepository;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    @Test
    void testCreate() {
        Product product = new Product();

        Product result = productService.create(product);

        verify(productRepository, times(1)).create(product);
        assertEquals(product, result);
    }

    @Test
    void testFindAll() {
        Product p1 = new Product();
        Product p2 = new Product();
        List<Product> productList = Arrays.asList(p1, p2);
        Iterator<Product> iterator = productList.iterator();

        when(productRepository.findAll()).thenReturn(iterator);

        List<Product> result = productService.findAll();

        assertEquals(2, result.size());
        verify(productRepository, times(1)).findAll();
    }

    @Test
    void testFindById() {
        Product product = new Product();

        when(productRepository.findById(product.getProductId())).thenReturn(product);

        Product result = productService.findById(product.getProductId());

        assertNotNull(result);
        assertEquals(product.getProductId(), result.getProductId());
    }

    @Test
    void testUpdate() {
        Product product = new Product();

        Product result = productService.update(product);

        verify(productRepository, times(1)).update(product);
        assertEquals(product, result);
    }

    @Test
    void testDelete() {
        Product product = new Product();

        productService.delete(product.getProductId());

        verify(productRepository, times(1)).delete(product.getProductId());
    }
}
