package studiocephei.sprouttech;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 */
public class FragmentTechnical extends Fragment {

    ImageView mImageView;
    Bitmap mBitmap;
    InvestmentActivity mActivityInvest;



    public FragmentTechnical() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_technical, container, false);
        mActivityInvest = (InvestmentActivity) getActivity();
        mImageView = (ImageView)v.findViewById(R.id.iv_image);
        getImage();
        //get data from investment activity
        return v;
    }

    private void getImage(){
        switch (mActivityInvest.getChoice()){
            case 0:
                mBitmap = Constants.decodeSampledBitmapFromResource(getResources(),R.drawable.stay_graph, 400, 400);
                mImageView.setImageBitmap(mBitmap);
                break;
            case 1:
                mBitmap = Constants.decodeSampledBitmapFromResource(getResources(),R.drawable.slow_sprout, 400, 400);
                mImageView.setImageBitmap(mBitmap);
        }
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    public static FragmentTechnical newInstance() {
        FragmentTechnical fragmentTechnical = new FragmentTechnical();
        return fragmentTechnical;
    }

    public void update(int progress){
        switch (progress){
            case 0:
                mBitmap = Constants.decodeSampledBitmapFromResource(getResources(),R.drawable.stay_graph, 400, 400);
                mImageView.setImageBitmap(mBitmap);
                break;
            case 1:
                mBitmap = Constants.decodeSampledBitmapFromResource(getResources(),R.drawable.slow_graph, 400, 400);
                mImageView.setImageBitmap(mBitmap);
                break;
            case 2:
                mBitmap = Constants.decodeSampledBitmapFromResource(getResources(),R.drawable.stable_graph, 400, 400);
                mImageView.setImageBitmap(mBitmap);
                break;
            case 3:
                mBitmap = Constants.decodeSampledBitmapFromResource(getResources(),R.drawable.surge_graph, 400, 400);
                mImageView.setImageBitmap(mBitmap);
                break;
        }
    }

}
