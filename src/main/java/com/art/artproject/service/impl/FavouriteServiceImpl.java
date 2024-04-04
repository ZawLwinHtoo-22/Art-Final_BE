package com.art.artproject.service.impl;

import com.art.artproject.dto.FavouriteRequest;
import com.art.artproject.entity.Card;
import com.art.artproject.entity.Favourite;
import com.art.artproject.entity.User;
import com.art.artproject.repo.CardRepo;
import com.art.artproject.repo.FavouriteRepo;
import com.art.artproject.repo.UserRepo;
import com.art.artproject.service.FavouriteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FavouriteServiceImpl implements FavouriteService {

    @Autowired
    private FavouriteRepo favouriteRepo;

    @Autowired
    private FavouriteService favouriteService;

    @Autowired
    private CardRepo cardRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    public ModelMapper mapper;


    @Override
    public Favourite doFavourite(Long user_id, Long card_id,FavouriteRequest request) {
        Favourite favourite=mapper.map(request,Favourite.class);
        User user=userRepo.findById(user_id).get();
        Card card=cardRepo.findById(card_id).get();
        favourite.setUser(user);
        favourite.setCard(card);
        return favouriteRepo.save(favourite);
    }

    @Override
    public List<Favourite> showAll() {
        return favouriteRepo.findAll();
    }



    @Override
    public void deleteFavourite(Long id) {
        if(favouriteRepo.existsById(id)){
            favouriteRepo.deleteById(id);
        }
    }

}