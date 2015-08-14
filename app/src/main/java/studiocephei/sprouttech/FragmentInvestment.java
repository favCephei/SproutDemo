package studiocephei.sprouttech;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 */
public class FragmentInvestment extends Fragment {


    private SeekBar mSeekBar;
    private HomeActivity actHome;
    private View mView;
    private Bitmap mBitmap;
    private ImageView mMySprout;


    public FragmentInvestment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        actHome = (HomeActivity) getActivity();
        mView = inflater.inflate(R.layout.fragment_investment, container, false);
        mSeekBar = (SeekBar) mView.findViewById(R.id.sk_bar);
        mBitmap = Constants.decodeSampledBitmapFromResource(getResources(),R.drawable.stay_sprout, 250, 250);
        mMySprout = (ImageView) mView.findViewById(R.id.img_sprout);
        mMySprout.setImageBitmap(mBitmap);
        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                Toast.makeText(getActivity(), "Seekbar pos: " + progress, Toast.LENGTH_SHORT).show();
                switch(progress){
                    case 0:
                        mBitmap = Constants.decodeSampledBitmapFromResource(getResources(),R.drawable.stay_sprout, 250, 250);
                        mMySprout.setImageBitmap(mBitmap);
                        break;
                    case 1:
                        mBitmap = Constants.decodeSampledBitmapFromResource(getResources(),R.drawable.slow_sprout, 250, 250);
                        mMySprout.setImageBitmap(mBitmap);
                        break;
                    case 2:
                        mBitmap = Constants.decodeSampledBitmapFromResource(getResources(),R.drawable.stable_sprout, 250, 250);
                        mMySprout.setImageBitmap(mBitmap);
                        break;
                    case 3:
                        mBitmap = Constants.decodeSampledBitmapFromResource(getResources(),R.drawable.surge_sprout, 250, 250);
                        mMySprout.setImageBitmap(mBitmap);
                        break;
                }

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        return mView;
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    private void startWizard(){
        actHome.switchToWizard();
    }

    private void switchInvest(){
        actHome.switchToInvestment();
    }



}
