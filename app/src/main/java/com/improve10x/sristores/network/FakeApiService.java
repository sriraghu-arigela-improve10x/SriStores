package com.improve10x.sristores.network;

import com.improve10x.Constance;
import com.improve10x.sristores.models.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface FakeApiService {

    @GET(Constance.KEY_CATEGORIES)
    Call<List<String>> fetchCategories();

    @GET(Constance.KEY_CATEGORYNAME)
    Call<List<Product>> fetchProducts(@Path("categoryName") String categoryName);

    @GET(Constance.KEY_PRODUCTSID)
    Call<Product> fetchProductDetails(@Path("productsId") int productsId);
}
