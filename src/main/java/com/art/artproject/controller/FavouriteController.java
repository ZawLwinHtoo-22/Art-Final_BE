//package com.art.artproject.controller;
//
//import com.art.artproject.domain.TalentResponse;
//import com.art.artproject.dto.FavouriteRequest;
//import com.art.artproject.entity.Favourite;
//import com.art.artproject.service.FavouriteService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@CrossOrigin
//
//<<<<<<< HEAD
//@RequestMapping("/favourites")
//=======
//@RequestMapping("/favourite")
//>>>>>>> feature/ams
//
//public class FavouriteController {
//
//    @Autowired
//    private FavouriteService favouriteService;
//
//    @PostMapping
//<<<<<<< HEAD
//    public ResponseEntity<TalentResponse<Favourite>> doFavourite (@RequestParam Long user_id,Long card_id){
//        Favourite favourite = favouriteService.doFavourite(user_id,card_id);
//        TalentResponse response =
//                new TalentResponse<>(favourite, "Success favourite", HttpStatus.CREATED);
//=======
//    public ResponseEntity<TalentResponse> giveFavourite (@RequestParam String user_ids,Long card_id,@RequestBody FavouriteRequest request){
//        Favourite favourite = favouriteService.giveFavourite(user_ids,card_id, request);
//        TalentResponse response =
//                new TalentResponse<>(favourite, "success fav", HttpStatus.CREATED);
//>>>>>>> feature/ams
//        return new ResponseEntity<>(response, HttpStatus.CREATED);
//    }
//    @GetMapping
//    public ResponseEntity<TalentResponse<List<Favourite>>> showAll(){
//        List<Favourite> favourites=favouriteService.showAll();
//        TalentResponse response =
//                new TalentResponse<>(favourites, "success", HttpStatus.OK);
//        return new ResponseEntity<>(response, HttpStatus.OK);
//    }
//<<<<<<< HEAD
//
//=======
//    @PutMapping
//    public ResponseEntity<TalentResponse<Favourite>> updateFavourite(@RequestParam Long id,@RequestBody FavouriteRequest request){
//        Favourite favourite=favouriteService.updateNewFavourite(id,request);
//        TalentResponse response =
//                new TalentResponse<>(favourite, "success", HttpStatus.OK);
//        return new ResponseEntity<>(response, HttpStatus.OK);
//    }
//>>>>>>> feature/ams
//    @DeleteMapping
//    public ResponseEntity<String> deleteFavourite(@RequestParam Long id){
//        favouriteService.deleteFavourite(id);
//        return new ResponseEntity<>("Successfully deleted", HttpStatus.OK);
//    }
//}
