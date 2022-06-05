package com.example.newsapp;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements com.example.newsapp.VerticalAdapter.OnRowClickListener{
    RecyclerView recyclerViewHorizontal;
    HorizontalAdapter horizontalAdapter;
    List<Horizontal> HorizontalList = new ArrayList<>();
    Integer[] imageListH = {R.drawable.n1, R.drawable.hh, R.drawable.f, R.drawable.f2, R.drawable.kk, R.drawable.t};

    RecyclerView recyclerViewVertical;
    VerticalAdapter verticalAdapter;
    List<Vertical> VerticalList = new ArrayList<>();

    Integer[] imageList = {R.drawable.n1, R.drawable.hh, R.drawable.f, R.drawable.f2, R.drawable.kk, R.drawable.t};
    String[] nameList = {"Stranger Things S4 Vol.1","Harry's House","Brown Avocado","Apple and Cinnamon Cake","Kourtney and Travis' Wedding ","Businesses and Environment"};
    String[] descripList = {"The second volume of season 4 will continue from the dramatic ending of season 4 volume 1, which saw answers delivered about Vecna and may pose some questions about what comes next for Eleven.",
            "Harry Styles is king of the Billboard charts this week, no matter how one looks at the numbers. His new album Harry’s House is in charge of the Billboard 200, and its lead single “As It Was” is running the show on the Hot 100 yet again. Simply saying that either of these titles sit at No. 1 may be true, but there’s so much more to be said that points out just how massive this frame is for the former One Direction star.",
            "Use them straight away. You can mash the flesh, mix in a little lemon juice and freeze. The browning is caused by an enzyme called polyphenol oxidase. By stopping air getting to the exposed flesh, you will slow down the enzymatic reaction. Cover the cut surface tightly with plastic film or brush it with olive oil. Covering the cut surface with lemon juice will deactivate the enzyme.",
            "here's why it works: as the grated apple mix stews and bakes, it releases just enough liquid to bind the dry ingredients together into a crumbly consistency that yields a surprisingly light, logic-AND-gravity-defying crumble cake mash-up.",
            "Kourtney Kardashian and Travis Barker's relatively speedy when-you-know-you-know journey to married life started with a tequila-fueled trial run at a Las Vegas wedding chapel in April.",
            "Issues regarding how companies have affected the environment haven’t developed overnight — and they aren’t likely to disappear overnight, either. Smart businesses understand this, and rather than focusing on short-term earnings, they consider environmental investments that will deliver long-term value for themselves and the planet. Even some traditional big businesses are betting big with sustainability investments."};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewHorizontal = findViewById(R.id.horizontalView);
        horizontalAdapter = new HorizontalAdapter(HorizontalList, this);
        recyclerViewHorizontal.setAdapter(horizontalAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerViewHorizontal.setLayoutManager(layoutManager);
        layoutManager.setOrientation(RecyclerView.HORIZONTAL);
        for (int i = 0; i < imageListH.length; i++){
            com.example.newsapp.Horizontal horizontal = new com.example.newsapp.Horizontal(i, imageListH[i]);
            HorizontalList.add(horizontal);
        }

        recyclerViewVertical = findViewById(R.id.verticalView);
        verticalAdapter = new VerticalAdapter(VerticalList, MainActivity.this.getApplicationContext(), this);
        recyclerViewVertical.setAdapter(verticalAdapter);
        recyclerViewVertical.setLayoutManager(new LinearLayoutManager(this));

        for (int i = 0; i < imageList.length; i++){
            com.example.newsapp.Vertical vertical = new com.example.newsapp.Vertical(i,imageList[i],nameList[i],descripList[i]);
            VerticalList.add(vertical);
        }
    }

    @Override
    public void onItemClick(int position) {
        Fragment fragment;
        switch (position){
            case 0:
                fragment = new Fragment1();
                break;
            case 1:
                fragment = new Fragment2();
                break;
            case 2:
                fragment = new Fragment3();
                break;
            case 3:
                fragment = new Fragment4();
                break;
            case 4:
                fragment = new Fragment5();
                break;
            case 5:
                fragment = new Fragment6();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + position);
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment, fragment).commit();
    }
}