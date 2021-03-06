package com.ihavenoideawhatimdoing.takingitcasual.kana.menus;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.Space;
import android.support.v7.widget.AppCompatImageView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.ihavenoideawhatimdoing.takingitcasual.kana.R;
import com.ihavenoideawhatimdoing.takingitcasual.kana.singleton.GlobalSingleton;
import com.ihavenoideawhatimdoing.takingitcasual.kana.singleton.KanaTag;

import java.util.ArrayList;

public class KanaEdit extends android.support.v4.app.Fragment {

    GlobalSingleton g;

    ArrayList<AppCompatImageView> kanaImgs = new ArrayList<>();

    public KanaEdit() {
        // Required empty public constructor
    }

    public static KanaEdit newInstance() {
        KanaEdit fragment = new KanaEdit();
        // Bundle args = new Bundle();
        // args.putInt("Unused", Unused);
        // fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        g = GlobalSingleton.getSingletonObject();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final ScrollView parentScroll = new ScrollView(getActivity());
        parentScroll.setLayoutParams(new ScrollView.LayoutParams(
                ScrollView.LayoutParams.MATCH_PARENT,
                ScrollView.LayoutParams.WRAP_CONTENT
        ));
        parentScroll.setHorizontalScrollBarEnabled(false);
        parentScroll.setVerticalScrollBarEnabled(false);

        final TableLayout tableLayout = new TableLayout(getActivity());
        tableLayout.setLayoutParams(new TableLayout.LayoutParams(
                TableLayout.LayoutParams.MATCH_PARENT,
                TableLayout.LayoutParams.WRAP_CONTENT
        ));
        tableLayout.setStretchAllColumns(true);
        tableLayout.setShrinkAllColumns(true);
        tableLayout.setId(R.id.kanaTable);

        for (int i = 0; i < 16; i++) {
            final TableRow tableRow = new TableRow(getActivity());
            tableRow.setLayoutParams(new TableLayout.LayoutParams(
                    TableLayout.LayoutParams.MATCH_PARENT,
                    TableLayout.LayoutParams.WRAP_CONTENT
            ));

            for (int i2 = 0; i2 < 5; i2++) {
                if (!g.IndexToSound(5 * i + i2).isEmpty()){
                    final LinearLayout button = new LinearLayout(getActivity());
                    TableRow.LayoutParams params = new TableRow.LayoutParams(
                            TableRow.LayoutParams.WRAP_CONTENT,
                            TableRow.LayoutParams.WRAP_CONTENT
                    );
                    Context context = button.getContext();
                    final int margin = context.getResources().getDimensionPixelSize(R.dimen.spacing_tiny);
                    params.setMargins(margin, margin, margin, margin);
                    button.setLayoutParams(params);

                    button.setOrientation(LinearLayout.VERTICAL);
                    button.setBackgroundResource(R.drawable.btn_kana);
                    button.setClickable(true);
                    button.setFocusable(true);
                    button.setPadding(margin, margin, margin, margin);
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            //TODO: Connect kana buttons to data/descriptions
                        }
                    });

                    final AppCompatImageView buttonImage = new AppCompatImageView(getActivity());
                    buttonImage.setLayoutParams(new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.WRAP_CONTENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT
                    ));
                    buttonImage.setTag(new KanaTag(g.IndexToSound(5 * i + i2)));
                    kanaImgs.add(buttonImage);

                    context = buttonImage.getContext();
                    int img = context.getResources().getIdentifier(
                            "z0" + g.IndexToHex(5 * i + i2), "drawable", context.getPackageName());

                    buttonImage.setImageResource(img);
                    buttonImage.setColorFilter(ContextCompat.getColor(context, R.color.black));
                    buttonImage.setScaleType(AppCompatImageView.ScaleType.CENTER_INSIDE);
                    buttonImage.setAdjustViewBounds(true);

                    final TextView buttonText = new TextView(getActivity());
                    buttonText.setLayoutParams(new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.MATCH_PARENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT
                    ));
                    buttonText.setGravity(Gravity.CENTER_HORIZONTAL);
                    buttonText.setText(g.IndexToSound(5 * i + i2));
                    buttonText.setTypeface(null, Typeface.BOLD);

                    button.addView(buttonImage);
                    button.addView(buttonText);
                    tableRow.addView(button);
                }else{
                    final Space emptySpace = new Space(getActivity());
                    tableRow.addView(emptySpace);
                }
            }
            tableLayout.addView(tableRow);
        }
        parentScroll.addView(tableLayout);

        return parentScroll;
    }

    public void reloadKana(){
        TableLayout kanaTable = (TableLayout)getActivity().findViewById(R.id.kanaTable);
        for(AppCompatImageView imageView: kanaImgs){
            KanaTag kanaTag = (KanaTag)imageView.getTag();

            Context context = imageView.getContext();
            int img = context.getResources().getIdentifier(
                    "z0" + g.SoundToHex(kanaTag.sound), "drawable", context.getPackageName());
            imageView.setImageResource(img);
        }
    }

}
