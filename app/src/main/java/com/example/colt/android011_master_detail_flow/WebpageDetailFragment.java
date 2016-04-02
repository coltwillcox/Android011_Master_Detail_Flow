package com.example.colt.android011_master_detail_flow;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.example.colt.android011_master_detail_flow.dummy.DummyContent;

public class WebpageDetailFragment extends Fragment {

    public static final String ARG_ITEM_ID = "item_id";
    private DummyContent.DummyItem mItem;

    public WebpageDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments().containsKey(ARG_ITEM_ID)) {
            mItem = DummyContent.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.webpage_detail, container, false); //Point to XML file.
        if (mItem != null) {
            WebView view = (WebView) rootView.findViewById(R.id.detail_area);
            view.setWebViewClient(new WebViewClient());
            view.getSettings().setJavaScriptEnabled(true);
            view.setLayerType(View.LAYER_TYPE_HARDWARE, null);
            view.loadUrl(mItem.url); //Points to DummyItem.
        }
        return rootView;
    }

}