package com.example.demo.User;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.spring.web.json.Json;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/api")
public class UserController {


    @GetMapping("/response_time")
    public Json getUsers() throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()  .connectTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .build();
        Request request = new Request.Builder()

                .url("https://social-media-stats-and-data.herokuapp.com/response_time")
//                .method("GET", null)
//                .addHeader("Content-Type", "application/json")
//                .addHeader("cache-control", "no-cache")
//                .addHeader("Authorization", "Bearer EAAMdU4MhaoABAA4bJlofLZCfQwlhTZAOY1SMZBbQi91pDZCZB9ETeAV0znZBw3r3Gr7FaBMSiZCZCVYfrsPSKRoHwf71oRGSDwqyDwectnM4GGvXYjYqrhAOpkPcZB8mHLNyupz7yiQIDWz7LqaZBgRKnWArVsgOQJgf5DRyudwrJoLpGq0ZB4qLYs5")
                .build();
        Response response = client.newCall(request).execute();
        if (response.body() != null) {
            return new Json(response.body().string());
        }
        return new Json("");

    }

//    @PostMapping("/add_user")
//    public void createUser(@RequestBody UserTable user) {
//        userService.addUser(user);
//
//    }
//
//    @DeleteMapping("/delete_user/{id}")
//    public void deleteUser(@PathVariable Long id) {
//        if (userService.findUserById(id).isPresent())
//            userService.deleteUser(id);
//        else throw new IllegalStateException("User not found");
//
//    }
//
//    @PutMapping("/update_user/{id}")
//    public void updateUser(@PathVariable Long id, @RequestParam(required = false) String name) {
//        userService.updateUser(id, name);
//
//    }
}