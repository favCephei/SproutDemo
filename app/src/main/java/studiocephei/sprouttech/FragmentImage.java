package studiocephei.sprouttech;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 */
public class FragmentImage extends Fragment {

    ImageView mImageView;
    Bitmap mBitmap;



    public FragmentImage() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_image, container, false);
        mImageView = (ImageView)v.findViewById(R.id.iv_image);
        mBitmap = Constants.decodeSampledBitmapFromResource(getResources(),R.drawable.stay_sprout, 400, 400);
        mImageView.setImageBitmap(mBitmap);
        //get data from investment activity
        return v;
    }



    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    public static FragmentImage newInstance() {
        FragmentImage fragmentImage = new FragmentImage();
        return fragmentImage;
    }

    public void update(int progress){
        switch (progress){
            case 0:
                mBitmap = Constants.decodeSampledBitmapFromResource(getResources(),R.drawable.stay_sprout, 400, 400);
                mImageView.setImageBitmap(mBitmap);
                break;
            case 1:
                mBitmap = Constants.decodeSampledBitmapFromResource(getResources(),R.drawable.slow_sprout, 400, 400);
                mImageView.setImageBitmap(mBitmap);
                break;
            case 2:
                mBitmap = Constants.decodeSampledBitmapFromResource(getResources(),R.drawable.stable_sprout, 400, 400);
                mImageView.setImageBitmap(mBitmap);
                break;
            case 3:
                mBitmap = Constants.decodeSampledBitmapFromResource(getResources(),R.drawable.surge_sprout, 400, 400);
                mImageView.setImageBitmap(mBitmap);
                break;
        }
    }


}
