package com.egor.kurakovegornews;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import ru.mail.park.articlelistlib.Article;

/**
 * Created by egor on 07.03.18.
 */

public class ArticleFragment extends Fragment {

    Article article;

    public void setArticle(Article article) {
        this.article = article;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return createView();
    }

    private View createView() {
        LinearLayout layout = new LinearLayout(getContext());

        TextView textViewContent = new TextView(getContext());
        textViewContent.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT)
        );
        textViewContent.setText(article.getDate() + "\r\n" + article.getTitle() + "\r\n" + article.getContent());
        textViewContent.setTextColor(Color.BLACK);
        layout.addView(textViewContent);

        return layout;
    }
}