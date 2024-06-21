package com.samuel.sisvita17.network;

import com.samuel.sisvita17.data.model.Question;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface QuestionService {
    @GET("preguntas/")
    Call<List<Question>> getQuestions();
}
