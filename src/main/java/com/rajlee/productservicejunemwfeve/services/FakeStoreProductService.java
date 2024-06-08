package com.rajlee.productservicejunemwfeve.services;

import com.rajlee.productservicejunemwfeve.dtos.FakeStoreProductDto;
import com.rajlee.productservicejunemwfeve.models.Category;
import com.rajlee.productservicejunemwfeve.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService{
    private RestTemplate restTemplate;

    @Autowired
    public FakeStoreProductService(RestTemplate restTemplate){
        this.restTemplate=restTemplate;
    }

    private Product convertFakeStoreProductToProduct(FakeStoreProductDto fakeStoreProductDto){
        Product product = new Product();
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setId(fakeStoreProductDto.getId());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setImageUrl(fakeStoreProductDto.getImage());
//        product.setCategory(new Category());
//        product.getCategory().setName(fakeStoreProductDto.getCategory());

        return product;
    }
//    @Override
//    public Product getSingleProduct(Long id){
//         //   throw new RuntimeException("Something has happened");
//        // int a=1/0;
//       FakeStoreProductDto productDto = restTemplate.getForObject("https://fakestoreapi.com/products/1" + id, FakeStoreProductDto.class);
//        return convertFakeStoreProductToProduct(productDto);
//    }

    @Override
    public Product findById(Long id) {
        return restTemplate.getForObject("https://fakestoreapi.com/products/" + id, Product.class);
    }

    @Override
    public List<Product> getAllProducts(){
//       List<FakeStoreProductDto> response = restTemplate.getForObject("https://fakestoreapi.com/products",List<FakeStoreProductDto>.class);
        FakeStoreProductDto[] response = restTemplate.getForObject(
                "https://fakestoreapi.com/products",
                FakeStoreProductDto[].class);
        List<Product> answer = new ArrayList<>();


        for(FakeStoreProductDto dto:response){
           answer.add(convertFakeStoreProductToProduct(dto));
       }
        return answer;
    }
    @Override
    public Product replaceProduct(Long id, Product product){
        RequestCallback requestCallBack = restTemplate.httpEntityCallback(new FakeStoreProductDto(), FakeStoreProductDto.class);
        HttpMessageConverterExtractor<FakeStoreProductDto> responseExtractor =
                new HttpMessageConverterExtractor<>(FakeStoreProductDto.class,restTemplate.getMessageConverters());
        FakeStoreProductDto response = restTemplate.execute("https://fakestoreapi.com/products/"+id, HttpMethod.PUT,requestCallBack,responseExtractor);
        return convertFakeStoreProductToProduct(response);
    }
}
