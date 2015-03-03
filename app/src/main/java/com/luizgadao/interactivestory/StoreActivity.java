package com.luizgadao.interactivestory;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class StoreActivity extends ActionBarActivity {

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_store );
        if ( savedInstanceState == null ) {
            getSupportFragmentManager().beginTransaction()
                    .add( R.id.container, new StoreFragment() )
                    .commit();
        }
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class StoreFragment extends Fragment {

        private static final String TAG = StoreFragment.class.getSimpleName();

        public StoreFragment() {
        }

        @Override
        public View onCreateView( LayoutInflater inflater, ViewGroup container,
                                  Bundle savedInstanceState ) {
            View rootView = inflater.inflate( R.layout.fragment_store, container, false );
            return rootView;
        }

        @Override
        public void onViewCreated( View view, @Nullable Bundle savedInstanceState ) {
            super.onViewCreated( view, savedInstanceState );

            Intent intent = getActivity().getIntent();
            String name = intent.getStringExtra( getString( R.string.name ) );

            Log.i( TAG, name );
        }
    }
}
