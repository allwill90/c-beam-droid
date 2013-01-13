package org.c_base.c_beam;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.ToggleButton;



public class C_ontrolFragment extends Fragment {
	View thisView;
	ProgressBar input;
	C_ontrolFragment cf = this;
	AlertDialog pd;
	AlertDialog bam;
	int progress;
	C_beam c_beam;
	Fragment c_leuseFragment; 

	public C_ontrolFragment() {
		this.c_beam = null;
	}

	public C_ontrolFragment(C_beam c_beam) {
		this.c_beam = c_beam;
	}

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		if (container == null) {
			return null;
		}

		View v = inflater.inflate(R.layout.fragment_c_ontrol, container, false);
		//
		//		getChildFragmentManager().findFragmentById(R.layout.fragment_c_leuse);
		//
		//		c_leuseFragment = new C_leuseFragment(c_beam);
		//		FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
		//		transaction.add(R.id.RelativeLayout2, c_leuseFragment).commit();



		Button b = (Button) v.findViewById(R.id.button_self_destruct);

		AlertDialog.Builder adb = new AlertDialog.Builder(v.getContext());
		adb.setTitle("BAM!");
		adb.setPositiveButton("Danke", null);
		bam = adb.create();

		b.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				AlertDialog.Builder b = new AlertDialog.Builder(v.getContext());
				b.setTitle("Erde wird abgesprengt, bitte warten...");
				input = new ProgressBar(v.getContext(), null, android.R.attr.progressBarStyleHorizontal);
				b.setView(input);
				b.setPositiveButton("Danke f�r den Fisch.", null);

				pd = b.create();
				pd.show();

				Runnable r = new Runnable(){
					@Override
					public void run() {
						Looper.prepare();
						for (progress = 0; progress < 100; progress++) {
							try {
								if (progress < 97) {
									Thread.sleep(5);
								} else {
									Thread.sleep(2000);
								}
								//Thread.sleep(2*progress);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							input.setProgress(progress);
						}
						Log.i("thread", "done");
						pd.dismiss();
						Intent myIntent = new Intent(cf.getActivity(), BamActivity.class);
						startActivityForResult(myIntent, 0);
					}
					public int getProgress(){
						return progress;
					}
				};
				Thread thread = new Thread(r);
				thread.start();


			}			
		});

		b = (Button) v.findViewById(R.id.button_liftoff);
		b.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				AlertDialog.Builder b = new AlertDialog.Builder(v.getContext());
				b.setTitle("We need to lift off...");
				b.setMessage("There's no time to explain!");
				b.setPositiveButton("OK", null);
				b.show();
			}
		});	



		ToggleButton t = (ToggleButton) v.findViewById(R.id.toggleButtonBluewall);
		t.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				ToggleButton t = (ToggleButton) v;
				if (c_beam != null) {
					if (t.isChecked()) {
						c_beam.bluewall();
					} else {
						c_beam.bluewall();
					}
				}
			}
		});	

		b = (Button) v.findViewById(R.id.button_softwareverbrennung);
		b.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				c_beam.hwstorage(true);
			}
		});	
		/* */
		b = (Button) v.findViewById(R.id.button1);
		b.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				c_beam.set_stripe_pattern(0);
			}
		});	

		b = (Button) v.findViewById(R.id.button2);
		b.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				c_beam.set_stripe_pattern(1);
			}
		});	

		b = (Button) v.findViewById(R.id.button3);
		b.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				c_beam.set_stripe_pattern(2);
			}
		});	

		b = (Button) v.findViewById(R.id.button4);
		b.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				c_beam.set_stripe_pattern(3);
			}
		});	

		b = (Button) v.findViewById(R.id.button5);
		b.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				c_beam.set_stripe_pattern(5);
			}
		});	

		b = (Button) v.findViewById(R.id.button6);
		b.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				c_beam.set_stripe_pattern(4);
			}
		});	

		b = (Button) v.findViewById(R.id.button7);
		b.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				c_beam.set_stripe_pattern(6);
			}
		});	

		b = (Button) v.findViewById(R.id.button_speed_plus_9);
		b.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				c_beam.set_stripe_speed(9);
			}
		});


		b = (Button) v.findViewById(R.id.button8);
		b.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				c_beam.set_stripe_speed(6);
			}
		});

		b = (Button) v.findViewById(R.id.button9);
		b.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				c_beam.set_stripe_speed(3);
			}
		});

		b = (Button) v.findViewById(R.id.button10);
		b.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				c_beam.set_stripe_speed(0);
			}
		});

		b = (Button) v.findViewById(R.id.button11);
		b.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				c_beam.set_stripe_speed(-3);
			}
		});

		b = (Button) v.findViewById(R.id.button12);
		b.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				c_beam.set_stripe_speed(-6);
			}
		});

		b = (Button) v.findViewById(R.id.button_speed_minus_9);
		b.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				c_beam.set_stripe_speed(-9);
			}
		});

		b = (Button) v.findViewById(R.id.button_emergency_lights);
		b.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				c_beam.notbeleuchtung();
			}
		});

		b = (Button) v.findViewById(R.id.button_small_blue);
		b.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				c_beam.set_stripe_pattern(7);
			}
		});

		b = (Button) v.findViewById(R.id.button_small_green);
		b.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				c_beam.set_stripe_pattern(8);
			}
		});

		b = (Button) v.findViewById(R.id.button_small_red);
		b.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				c_beam.set_stripe_pattern(9);
			}
		});

		b = (Button) v.findViewById(R.id.button_pattern_default);
		b.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				c_beam.set_stripe_default();
			}
		});
		/* */
		thisView = v;
		return v;
	}

	@Override
	public void onViewStateRestored(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onViewStateRestored(savedInstanceState);
	}

	/*@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onViewCreated(view, savedInstanceState);

		RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
		params.addRule(RelativeLayout.BELOW, R.id.button_unlabeled);
		c_leuseFragment.getView().setLayoutParams(params);
	}*/



}
