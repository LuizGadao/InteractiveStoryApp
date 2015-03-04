package com.luizgadao.interactivestory.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.luizgadao.interactivestory.R;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        if ( savedInstanceState == null ) {
            getSupportFragmentManager().beginTransaction()
                    .add( R.id.container, new MainFragment() )
                    .commit();
        }
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class MainFragment extends Fragment {

        private EditText edName;
        private Button btStart;

        public MainFragment() {
        }

        @Override
        public View onCreateView( LayoutInflater inflater, ViewGroup container,
                                  Bundle savedInstanceState ) {
            View rootView = inflater.inflate( R.layout.fragment_main, container, false );
            return rootView;
        }

        @Override
        public void onViewCreated( View view, @Nullable Bundle savedInstanceState ) {
            super.onViewCreated( view, savedInstanceState );

            edName = ( EditText ) view.findViewById( R.id.et_name );
            btStart = ( Button ) view.findViewById( R.id.bt_start );

            btStart.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick( View v ) {
                    String name = edName.getText().toString();
                    startStory( name );
                }
            } );
        }

        private void startStory(String name) {
            Intent intent = new Intent( getActivity(), StoreActivity.class );
            intent.putExtra( getString( R.string.name ), name  );
            startActivity( intent );
        }
    }
}
