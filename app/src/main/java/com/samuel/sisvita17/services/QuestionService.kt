package com.samuel.sisvita17.services

import com.samuel.sisvita17.network.ApiClient
import com.samuel.sisvita17.network.QuestionService

val questionService = ApiClient.getRetrofitInstance().create(QuestionService::class.java)
val call = questionService.questions
