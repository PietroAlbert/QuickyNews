package it.unipd.dei.esp1920.quickynews.fragments;

/*
*
* CLASS WHERE I CAN SEE ALL THE NEWS
* WHICH HAVE THE ATTRIBUTE isFavorite
* SET TO true.
*
* */


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import it.unipd.dei.esp1920.quickynews.R;
import it.unipd.dei.esp1920.quickynews.fragments.TopNews;
import it.unipd.dei.esp1920.quickynews.news.MyRepository;
import it.unipd.dei.esp1920.quickynews.news.NewsApiResponse;
import it.unipd.dei.esp1920.quickynews.news.NewsListAdapter;

public class Saved extends Fragment {

    private final static String TAG="Saved";
    private RecyclerView recyclerView;
    private MyRepository myRepository ;


    @Override
    public void onCreate(Bundle bundle){
        super.onCreate(bundle);
        Log.d(TAG,"onCreate()");

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG,"onCreateView");
        View view = inflater.inflate(R.layout.fragment_home,container,false);
        myRepository = TopNews.getRepository();
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        Log.d(TAG,"myRepository = "+myRepository);
        recyclerView.setAdapter(new NewsListAdapter(new NewsApiResponse("",myRepository.getFavoritesArticle())));
        return view;
    }

}
