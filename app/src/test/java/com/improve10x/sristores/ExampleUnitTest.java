package com.improve10x.sristores;

import org.junit.Test;

import static org.junit.Assert.*;

import com.google.gson.Gson;
import com.improve10x.sristores.cart.CartProduct;
import com.improve10x.sristores.models.Product;
import com.improve10x.sristores.network.FakeApi;
import com.improve10x.sristores.network.FakeApiService;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

   /* @Test
    public void getCategories() throws IOException {
        FakeApiService fakeApiService = new FakeApi().createFakeApiService();
        Call<List<String>> call = fakeApiService.fetchCategories();
        List<String> categories = call.execute().body();
        assertNotNull(categories);
        assertFalse(categories.isEmpty());
        System.out.println(new Gson().toJson(categories));
    }

    @Test
    public void getCategoryProduct() throws IOException {
        FakeApiService fakeApiService = new FakeApi().createFakeApiService();
        Call<List<Product>> call = fakeApiService.fetchProducts("electronics");
        List<Product> categories = call.execute().body();
        assertNotNull(categories);
        assertFalse(categories.isEmpty());
        System.out.println(new Gson().toJson(categories));
    }
*/
    @Test
    public void getCart() throws IOException {
        FakeApiService fakeApiService = new FakeApi().createFakeApiService();
        Call<CartProduct> call = fakeApiService.fetchCartProducts(1);
        CartProduct categories = call.execute().body();
        assertNotNull(categories);
        System.out.println(new Gson().toJson(categories));
    }
}