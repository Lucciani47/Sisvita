package com.samuel.sisvita17.network;

import com.samuel.sisvita17.data.model.User;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("usuarios/")
    Call<List<User>> getUsers();
}