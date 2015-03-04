package com.luizgadao.interactivestory.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.luizgadao.interactivestory.R;
import com.luizgadao.interactivestory.model.Page;
import com.luizgadao.interactivestory.model.Story;


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

        private TextView tv;
        private Button btOne, btTwo;
        private ImageView image;
        private String name;
        private Page currentPage;

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

            tv = ( TextView ) view.findViewById( R.id.textview );
            btOne = ( Button ) view.findViewById( R.id.bt_one );
            btTwo = ( Button ) view.findViewById( R.id.bt_two );
            image = ( ImageView ) view.findViewById( R.id.imageview );

            Intent intent = getActivity().getIntent();
            name = intent.getStringExtra( getString( R.string.name ) );
            loadPage( 0 );

            Log.i( TAG, name );

        }

        private void loadPage( int index ) {
            Story story = new Story();
            currentPage = story.getPage( index );

            image.setImageResource( currentPage.getImageId() );
            String textPage = String.format( currentPage.getText(), name );
            tv.setText( textPage );

            if ( ! currentPage.isFinal() )
            {
                btOne.setText( currentPage.getChoice1().getText() );
                btTwo.setText( currentPage.getChoice2().getText() );

                btOne.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick( View v ) {
                        int nextPage = currentPage.getChoice1().getNextPage();
                        loadPage( nextPage );
                    }
                } );

                btTwo.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick( View v ) {
                        int nextPage = currentPage.getChoice2().getNextPage();
                        loadPage( nextPage );
                    }
                } );
            }
            else {
                btOne.setVisibility( View.INVISIBLE );
                btTwo.setText( "Play again" );
                btTwo.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick( View v ) {
                        getActivity().finish();
                    }
                } );
            }


        }
    }
}
