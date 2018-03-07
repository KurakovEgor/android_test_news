package com.egor.kurakovegornews;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ru.mail.park.articlelistlib.Article;
import ru.mail.park.articlelistlib.ArticleListFragment;
import ru.mail.park.articlelistlib.OnArticleClickListener;

public class MainActivity extends AppCompatActivity {
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ArticleListFragment articleListFragment = new ArticleListFragment();
        articleListFragment.setOnArticleClickListener(new MyArticleClickListener());

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.news, articleListFragment);
        fragmentTransaction.commit();
    }

    private void addFragment(Article article) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        ArticleFragment articleFragment = new ArticleFragment();
        articleFragment.setArticle(article);
        fragmentTransaction.replace(R.id.news, articleFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    private class MyArticleClickListener implements OnArticleClickListener {

        @Override
        public void onArticleClick(Article article) {
            addFragment(article);
        }
    }
}
