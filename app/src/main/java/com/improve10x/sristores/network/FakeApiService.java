package com.improve10x.sristores.network;

import com.improve10x.sristores.cart.CartProduct;
import com.improve10x.sristores.models.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface FakeApiService {

    @GET("/products/categories")
    Call<List<String>> fetchCategories();

    @GET("/products/category/{categoryName}")
    Call<List<Product>> fetchProducts(@Path("categoryName") String categoryName);

    @GET("/products/{productsId}")
    Call<Product> fetchProductDetails(@Path("productsId") int productsId);

    @GET("/carts?userId=1")
    Call<CartProduct> fetchCartProducts(@Path("userId") int userId);
}
