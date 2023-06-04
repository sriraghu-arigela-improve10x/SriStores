package com.improve10x.sristores.network;

import com.improve10x.sristores.cart.CartProduct;
import com.improve10x.sristores.categories.Category;
import com.improve10x.sristores.models.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface FakeApiService {

    @GET("/api/v1/categories")
    Call<List<Category>> fetchCategories();

    @GET("/api/v1/products/?categoryId=1")
    Call<List<Product>> fetchProducts(@Path("categoryName") String categoryName);

    @GET("/products/{productsId}")
    Call<Product> fetchProductDetails(@Path("productsId") int productsId);

    @GET("carts/1?userId=1")
    Call<CartProduct> fetchCartProducts();
}
