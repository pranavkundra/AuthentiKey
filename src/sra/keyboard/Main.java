package sra.keyboard;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Vector;





import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;


public class Main extends Activity implements OnTouchListener, OnClickListener,
		OnFocusChangeListener  {
	private String password="HELLOWORLD";
	private EditText mEt; // Edit Text boxes
	private Button mBSpace, mBdone, mBack, mBChange, mNum;
	private RelativeLayout mLayout, mKLayout;
	private boolean isEdit = false;
	private String mUpper = "upper", mLower = "lower";
	private int w, mWindowWidth;
	byte[] buffer;
	long lastpress;
	  long lastrelease;
	 int trainpress;
	long press;
	long release;
	long keyhold;
	FileOutputStream fos;
	InputStream fis;
	BufferedReader br;
	boolean start=false;
	String filename="myfile";
	
	String lastkey;
	String storage="";
	Vector<String> text=new Vector<String>();
	Vector<Long> p=new Vector<Long>();
	Vector<Long> r=new Vector<Long>();
	Vector<Long> p2p1=new Vector<Long>();
	Vector<Long> p2r1=new Vector<Long>();
	Vector<Long> r2r1=new Vector<Long>();
	Vector<Long> kh= new Vector<Long>();
	int noofbs=0;
	String op;
	
	/////////////////////////////////////////////////////
	int NUMBER_OF_INPUTS;
    int NUMBER_OF_USER_CASES;
    int NUMBER_OF_LETTERS;
    
    double[] MEAN;
    double[] STANDARD_DEVIATION;
    double[][] USER_CASES;
    double[][] TEST_CASE;
    double[] NEW_USE_CASE;
    
    final int X=3;
    final int NO_OF_HITS=5;
    final int DEVIATION_FACTOR=2;
    double[] hits;
    double[] deviation;
    //////////////////////////////////////////////
	
	
	boolean isTrainPressed=false;
	private String sL[] = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
			"k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w",
			"x", "y", "z", "OK", "à", "é", "è", "û", "î" };
	private String cL[] = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
			"K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W",
			"X", "Y", "Z", "OK", "à", "é", "è", "û", "î" };
	private String nS[] = { "!", ")", "'", "#", "3", "$", "%", "&", "8", "*",
			"?", "/", "+", "-", "9", "0", "1", "4", "@", "5", "7", "(", "2",
			"\"", "6", "_", "=", "]", "[", "<", ">", "|" };
	private Button mB[] = new Button[27];
	Button mtrain,mtest;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		try {
			fos=openFileOutput(filename,Context.MODE_PRIVATE);
			 mtrain=(Button)findViewById(R.id.train);
			setContentView(R.layout.main);
			// adjusting key regarding window sizes
			setKeys();
			setFrow();
			setSrow();
			setTrow();
			setForow();
			mEt = (EditText) findViewById(R.id.xEt);
			mEt.setOnTouchListener(this);
			mEt.setOnFocusChangeListener(this);
			
			//mtrain.setOnTouchListener(this);
			
			//mEt1.setOnTouchListener(this);
			//mEt1.setOnFocusChangeListener(this);
			mEt.setOnClickListener(this);
			//mtrain.setOnTouchListener(this);
			//mEt1.setOnClickListener(this);
			mLayout = (RelativeLayout) findViewById(R.id.xK1);
			mKLayout = (RelativeLayout) findViewById(R.id.xKeyBoard);

		} catch (Exception e) {
			Log.w(getClass().getName(), e.toString());
		}
	

	
	
	//a
	 mB[0].setOnTouchListener(new OnTouchListener() {
	     @Override
	     public boolean onTouch(View v, MotionEvent event) {
		
		String buttonText = (String)v.getTag();
		        if(event.getAction() == MotionEvent.ACTION_DOWN) {
	           press = System.currentTimeMillis();
	           text.addElement(buttonText);
	           p.addElement(press);
	        }
		        else if (event.getAction() == MotionEvent.ACTION_UP) {
	          release = System.currentTimeMillis();
	          keyhold=release-press;
	  		//System.out.println(buttonText+keyhold);
	  		r.addElement(release);
	  		addText(v);
	  		////disp(buttonText+keyhold);
	  		
	  		}
			//done();	
		 return true;
	     }
	    
	  });
	
	
	
	
	//b
	mB[1].setOnTouchListener(new OnTouchListener() {
	     @Override
	     public boolean onTouch(View v, MotionEvent event) {
		
		String buttonText = (String)v.getTag();
		        if(event.getAction() == MotionEvent.ACTION_DOWN) {
	           press = System.currentTimeMillis();
	           text.addElement(buttonText);
	           p.addElement(press);
	        }
		        else if (event.getAction() == MotionEvent.ACTION_UP) {
	          release = System.currentTimeMillis();
	          keyhold=release-press;
	  		//System.out.println(buttonText+keyhold);
	  		r.addElement(release);
	  		addText(v);
	  		//////disp(buttonText+keyhold);
	  		
	  		}
				
		 return true;
	     }
	    
	  });
	
	
	//c
	mB[2].setOnTouchListener(new OnTouchListener() {
	     @Override
	     public boolean onTouch(View v, MotionEvent event) {
		
		String buttonText = (String)v.getTag();
		        if(event.getAction() == MotionEvent.ACTION_DOWN) {
	           press = System.currentTimeMillis();
	           text.addElement(buttonText);
	           p.addElement(press);
	        }
		        else if (event.getAction() == MotionEvent.ACTION_UP) {
	          release = System.currentTimeMillis();
	          keyhold=release-press;
	  		System.out.println(buttonText+keyhold);
	  		r.addElement(release);
	  		addText(v);
	  		//disp(buttonText+keyhold);
	  		
	  		}
				
		 return true;
	     }
	    
	  });
	
	
	//d
	mB[3].setOnTouchListener(new OnTouchListener() {
	     @Override
	     public boolean onTouch(View v, MotionEvent event) {
		
		String buttonText = (String)v.getTag();
		        if(event.getAction() == MotionEvent.ACTION_DOWN) {
	           press = System.currentTimeMillis();
	           text.addElement(buttonText);
	           p.addElement(press);
	        }
		        else if (event.getAction() == MotionEvent.ACTION_UP) {
	          release = System.currentTimeMillis();
	          keyhold=release-press;
	  		System.out.println(buttonText+keyhold);
	  		r.addElement(release);
	  		addText(v);
	  		//disp(buttonText+keyhold);
	  		
	  		}
				
		 return true;
	     }
	    
	  });
	
	
	//e
	mB[4].setOnTouchListener(new OnTouchListener() {
	     @Override
	     public boolean onTouch(View v, MotionEvent event) {
		
		String buttonText = (String)v.getTag();
		        if(event.getAction() == MotionEvent.ACTION_DOWN) {
	           press = System.currentTimeMillis();
	           text.addElement(buttonText);
	           p.addElement(press);
	        }
		        else if (event.getAction() == MotionEvent.ACTION_UP) {
	          release = System.currentTimeMillis();
	          keyhold=release-press;
	  		System.out.println(buttonText+keyhold);
	  		r.addElement(release);
	  		addText(v);
	  		//disp(buttonText+keyhold);
	  		
	  		}
				
		 return true;
	     }
	    
	  });
	
	
	//f
	mB[5].setOnTouchListener(new OnTouchListener() {
	     @Override
	     public boolean onTouch(View v, MotionEvent event) {
		
		String buttonText = (String)v.getTag();
		        if(event.getAction() == MotionEvent.ACTION_DOWN) {
	           press = System.currentTimeMillis();
	           text.addElement(buttonText);
	           p.addElement(press);
	        }
		        else if (event.getAction() == MotionEvent.ACTION_UP) {
	          release = System.currentTimeMillis();
	          keyhold=release-press;
	  		System.out.println(buttonText+keyhold);
	  		r.addElement(release);
	  		addText(v);
	  		//disp(buttonText+keyhold);
	  		
	  		}
				
		 return true;
	     }
	    
	  });
	
	
	//g
	mB[6].setOnTouchListener(new OnTouchListener() {
	     @Override
	     public boolean onTouch(View v, MotionEvent event) {
		
		String buttonText = (String)v.getTag();
		        if(event.getAction() == MotionEvent.ACTION_DOWN) {
	           press = System.currentTimeMillis();
	           text.addElement(buttonText);
	           p.addElement(press);
	        }
		        else if (event.getAction() == MotionEvent.ACTION_UP) {
	          release = System.currentTimeMillis();
	          keyhold=release-press;
	  		System.out.println(buttonText+keyhold);
	  		r.addElement(release);
	  		addText(v);
	  		//disp(buttonText+keyhold);
	  		  		
	  		  		}
	  					
	  			 return true;
	  		     }
	  		    
	  		  });
	  		
	  		
	//h
	  		mB[7].setOnTouchListener(new OnTouchListener() {
	  		     @Override
	  		     public boolean onTouch(View v, MotionEvent event) {
	  			
	  			String buttonText = (String)v.getTag();
	  			        if(event.getAction() == MotionEvent.ACTION_DOWN) {
	  		           press = System.currentTimeMillis();
	  		           text.addElement(buttonText);
	  		           p.addElement(press);
	  		        }
	  			        else if (event.getAction() == MotionEvent.ACTION_UP) {
	  		          release = System.currentTimeMillis();
	  		          keyhold=release-press;
	  		  		System.out.println(buttonText+keyhold);
	  		  		r.addElement(release);
	  		  		addText(v);
	  		  		//disp(buttonText+keyhold);
	  		  		
	  		  		}
	  					
	  			 return true;
	  		     }
	  		    
	  		  });
	  		
	  //i
	  		
	  		mB[8].setOnTouchListener(new OnTouchListener() {
	  		     @Override
	  		     public boolean onTouch(View v, MotionEvent event) {
	  			
	  			String buttonText = (String)v.getTag();
	  			        if(event.getAction() == MotionEvent.ACTION_DOWN) {
	  		           press = System.currentTimeMillis();
	  		           text.addElement(buttonText);
	  		           p.addElement(press);
	  		        }
	  			        else if (event.getAction() == MotionEvent.ACTION_UP) {
	  		          release = System.currentTimeMillis();
	  		          keyhold=release-press;
	  		  		System.out.println(buttonText+keyhold);
	  		  		r.addElement(release);
	  		  		addText(v);
	  		  		//disp(buttonText+keyhold);
	  		  		
	  		  		}
	  					
	  			 return true;
	  		     }
	  		    
	  		  });
	  		
	  		//j
	  		
	  		mB[9].setOnTouchListener(new OnTouchListener() {
	  		     @Override
	  		     public boolean onTouch(View v, MotionEvent event) {
	  			
	  			String buttonText = (String)v.getTag();
	  			        if(event.getAction() == MotionEvent.ACTION_DOWN) {
	  		           press = System.currentTimeMillis();
	  		           text.addElement(buttonText);
	  		           p.addElement(press);
	  		        }
	  			        else if (event.getAction() == MotionEvent.ACTION_UP) {
	  		          release = System.currentTimeMillis();
	  		          keyhold=release-press;
	  		  		System.out.println(buttonText+keyhold);
	  		  		r.addElement(release);
	  		  		addText(v);
	  		  		//disp(buttonText+keyhold);
	  		  		
	  		  		}
	  					
	  			 return true;
	  		     }
	  		    
	  		  });
	  		
	 //k
	  		
	  		mB[10].setOnTouchListener(new OnTouchListener() {
	  		     @Override
	  		     public boolean onTouch(View v, MotionEvent event) {
	  			
	  			String buttonText = (String)v.getTag();
	  			        if(event.getAction() == MotionEvent.ACTION_DOWN) {
	  		           press = System.currentTimeMillis();
	  		           text.addElement(buttonText);
	  		           p.addElement(press);
	  		        }
	  			        else if (event.getAction() == MotionEvent.ACTION_UP) {
	  		          release = System.currentTimeMillis();
	  		          keyhold=release-press;
	  		  		System.out.println(buttonText+keyhold);
	  		  		r.addElement(release);
	  		  		addText(v);
	  		  		//disp(buttonText+keyhold);
	  		  		
	  		  		}
	  					
	  			 return true;
	  		     }
	  		    
	  		  });
	  		
	  //l
	  		mB[11].setOnTouchListener(new OnTouchListener() {
	  		     @Override
	  		     public boolean onTouch(View v, MotionEvent event) {
	  			
	  			String buttonText = (String)v.getTag();
	  			        if(event.getAction() == MotionEvent.ACTION_DOWN) {
	  		           press = System.currentTimeMillis();
	  		           text.addElement(buttonText);
	  		           p.addElement(press);
	  		        }
	  			        else if (event.getAction() == MotionEvent.ACTION_UP) {
	  		          release = System.currentTimeMillis();
	  		          keyhold=release-press;
	  		  		System.out.println(buttonText+keyhold);
	  		  		r.addElement(release);
	  		  		addText(v);
	  		  		//disp(buttonText+keyhold);
	  		  		
	  		  		}
	  					
	  			 return true;
	  		     }
	  		    
	  		  });
	  		
	  //m
	  		
	  		mB[12].setOnTouchListener(new OnTouchListener() {
	  		     @Override
	  		     public boolean onTouch(View v, MotionEvent event) {
	  			
	  			String buttonText = (String)v.getTag();
	  			        if(event.getAction() == MotionEvent.ACTION_DOWN) {
	  		           press = System.currentTimeMillis();
	  		           text.addElement(buttonText);
	  		           p.addElement(press);
	  		        }
	  			        else if (event.getAction() == MotionEvent.ACTION_UP) {
	  		          release = System.currentTimeMillis();
	  		          keyhold=release-press;
	  		  		System.out.println(buttonText+keyhold);
	  		  		r.addElement(release);
	  		  		addText(v);
	  		  		//disp(buttonText+keyhold);
	  		  		
	  		  		}
	  					
	  			 return true;
	  		     }
	  		    
	  		  });
	  		
	  		
	  //n
	  		
	  		mB[13].setOnTouchListener(new OnTouchListener() {
	  		     @Override
	  		     public boolean onTouch(View v, MotionEvent event) {
	  			
	  			String buttonText = (String)v.getTag();
	  			        if(event.getAction() == MotionEvent.ACTION_DOWN) {
	  		           press = System.currentTimeMillis();
	  		           text.addElement(buttonText);
	  		           p.addElement(press);
	  		        }
	  			        else if (event.getAction() == MotionEvent.ACTION_UP) {
	  		          release = System.currentTimeMillis();
	  		          keyhold=release-press;
	  		  		System.out.println(buttonText+keyhold);
	  		  		r.addElement(release);
	  		  		addText(v);
	  		  		//disp(buttonText+keyhold);
	  		  		
	  		  		}
	  					
	  			 return true;
	  		     }
	  		    
	  		  });
	  		
	  		
	  		//o
	  		
	  		mB[14].setOnTouchListener(new OnTouchListener() {
	  		     @Override
	  		     public boolean onTouch(View v, MotionEvent event) {
	  			
	  			String buttonText = (String)v.getTag();
	  			        if(event.getAction() == MotionEvent.ACTION_DOWN) {
	  		           press = System.currentTimeMillis();
	  		           text.addElement(buttonText);
	  		           p.addElement(press);
	  		        }
	  			        else if (event.getAction() == MotionEvent.ACTION_UP) {
	  		          release = System.currentTimeMillis();
	  		          keyhold=release-press;
	  		  		System.out.println(buttonText+keyhold);
	  		  		r.addElement(release);
	  		  		addText(v);
	  		  		//disp(buttonText+keyhold);
	  		  		
	  		  		}
	  					
	  			 return true;
	  		     }
	  		    
	  		  });
	  		
	  		//p
	  		mB[15].setOnTouchListener(new OnTouchListener() {
	  		     @Override
	  		     public boolean onTouch(View v, MotionEvent event) {
	  			
	  			String buttonText = (String)v.getTag();
	  			        if(event.getAction() == MotionEvent.ACTION_DOWN) {
	  		           press = System.currentTimeMillis();
	  		           text.addElement(buttonText);
	  		           p.addElement(press);
	  		        }
	  			        else if (event.getAction() == MotionEvent.ACTION_UP) {
	  		          release = System.currentTimeMillis();
	  		          keyhold=release-press;
	  		  		System.out.println(buttonText+keyhold);
	  		  		r.addElement(release);
	  		  		addText(v);
	  		  		//disp(buttonText+keyhold);
	  		  		
	  		  		}
	  					
	  			 return true;
	  		     }
	  		    
	  		  });
	  		
	  		//q
	  		mB[16].setOnTouchListener(new OnTouchListener() {
	  		     @Override
	  		     public boolean onTouch(View v, MotionEvent event) {
	  			
	  			String buttonText = (String)v.getTag();
	  			        if(event.getAction() == MotionEvent.ACTION_DOWN) {
	  		           press = System.currentTimeMillis();
	  		           text.addElement(buttonText);
	  		           p.addElement(press);
	  		        }
	  			        else if (event.getAction() == MotionEvent.ACTION_UP) {
	  		          release = System.currentTimeMillis();
	  		          keyhold=release-press;
	  		  		System.out.println(buttonText+keyhold);
	  		  		r.addElement(release);
	  		  		addText(v);
	  		  		//disp(buttonText+keyhold);
	  		  		
	  		  		}
	  					
	  			 return true;
	  		     }
	  		    
	  		  });
	  		
	  		
	  		//r
	  		mB[17].setOnTouchListener(new OnTouchListener() {
	  		     @Override
	  		     public boolean onTouch(View v, MotionEvent event) {
	  			
	  			String buttonText = (String)v.getTag();
	  			        if(event.getAction() == MotionEvent.ACTION_DOWN) {
	  		           press = System.currentTimeMillis();
	  		           text.addElement(buttonText);
	  		           p.addElement(press);
	  		        }
	  			        else if (event.getAction() == MotionEvent.ACTION_UP) {
	  		          release = System.currentTimeMillis();
	  		          keyhold=release-press;
	  		  		System.out.println(buttonText+keyhold);
	  		  		r.addElement(release);
	  		  		addText(v);
	  		  		//disp(buttonText+keyhold);
	  		  		
	  		  		}
	  					
	  			 return true;
	  		     }
	  		    
	  		  });
	  		
	  		//s
	  		mB[18].setOnTouchListener(new OnTouchListener() {
	  		     @Override
	  		     public boolean onTouch(View v, MotionEvent event) {
	  			
	  			String buttonText = (String)v.getTag();
	  			        if(event.getAction() == MotionEvent.ACTION_DOWN) {
	  		           press = System.currentTimeMillis();
	  		           text.addElement(buttonText);
	  		           p.addElement(press);
	  		        }
	  			        else if (event.getAction() == MotionEvent.ACTION_UP) {
	  		          release = System.currentTimeMillis();
	  		          keyhold=release-press;
	  		  		System.out.println(buttonText+keyhold);
	  		  		r.addElement(release);
	  		  		addText(v);
	  		  		//disp(buttonText+keyhold);
	  		  		
	  		  		}
	  					
	  			 return true;
	  		     }
	  		    
	  		  });
	  		
	  		
	  		//t
	  		mB[19].setOnTouchListener(new OnTouchListener() {
	  		     @Override
	  		     public boolean onTouch(View v, MotionEvent event) {
	  			
	  			String buttonText = (String)v.getTag();
	  			        if(event.getAction() == MotionEvent.ACTION_DOWN) {
	  		           press = System.currentTimeMillis();
	  		           text.addElement(buttonText);
	  		           p.addElement(press);
	  		        }
	  			        else if (event.getAction() == MotionEvent.ACTION_UP) {
	  		          release = System.currentTimeMillis();
	  		          keyhold=release-press;
	  		  		System.out.println(buttonText+keyhold);
	  		  		r.addElement(release);
	  		  		addText(v);
	  		  		//disp(buttonText+keyhold);
	  		  		
	  		  		}
	  					
	  			 return true;
	  		     }
	  		    
	  		  });
	  		
	  		//u
	  		
	  		mB[20].setOnTouchListener(new OnTouchListener() {
	  		     @Override
	  		     public boolean onTouch(View v, MotionEvent event) {
	  			
	  			String buttonText = (String)v.getTag();
	  			        if(event.getAction() == MotionEvent.ACTION_DOWN) {
	  		           press = System.currentTimeMillis();
	  		           text.addElement(buttonText);
	  		           p.addElement(press);
	  		        }
	  			        else if (event.getAction() == MotionEvent.ACTION_UP) {
	  		          release = System.currentTimeMillis();
	  		          keyhold=release-press;
	  		  		System.out.println(buttonText+keyhold);
	  		  		r.addElement(release);
	  		  		addText(v);
	  		  		//disp(buttonText+keyhold);
	  		  		
	  		  		}
	  					
	  			 return true;
	  		     }
	  		    
	  		  });
	  		
	  		//v
	  		mB[21].setOnTouchListener(new OnTouchListener() {
	  		     @Override
	  		     public boolean onTouch(View v, MotionEvent event) {
	  			
	  			String buttonText = (String)v.getTag();
	  			        if(event.getAction() == MotionEvent.ACTION_DOWN) {
	  		           press = System.currentTimeMillis();
	  		           text.addElement(buttonText);
	  		           p.addElement(press);
	  		        }
	  			        else if (event.getAction() == MotionEvent.ACTION_UP) {
	  		          release = System.currentTimeMillis();
	  		          keyhold=release-press;
	  		  		System.out.println(buttonText+keyhold);
	  		  		r.addElement(release);
	  		  		addText(v);
	  		  		//disp(buttonText+keyhold);
	  		  		
	  		  		}
	  					
	  			 return true;
	  		     }
	  		    
	  		  });
	  		
	  		
	  		//w
	  		mB[22].setOnTouchListener(new OnTouchListener() {
	  		     @Override
	  		     public boolean onTouch(View v, MotionEvent event) {
	  			
	  			String buttonText = (String)v.getTag();
	  			        if(event.getAction() == MotionEvent.ACTION_DOWN) {
	  		           press = System.currentTimeMillis();
	  		           text.addElement(buttonText);
	  		           p.addElement(press);
	  		        }
	  			        else if (event.getAction() == MotionEvent.ACTION_UP) {
	  		          release = System.currentTimeMillis();
	  		          keyhold=release-press;
	  		  		System.out.println(buttonText+keyhold);
	  		  		r.addElement(release);
	  		  		addText(v);
	  		  		//disp(buttonText+keyhold);
	  		  		
	  		  		}
	  					
	  			 return true;
	  		     }
	  		    
	  		  });
	  		
	  		//x
	  		mB[23].setOnTouchListener(new OnTouchListener() {
	  		     @Override
	  		     public boolean onTouch(View v, MotionEvent event) {
	  			
	  			String buttonText = (String)v.getTag();
	  			        if(event.getAction() == MotionEvent.ACTION_DOWN) {
	  		           press = System.currentTimeMillis();
	  		           text.addElement(buttonText);
	  		           p.addElement(press);
	  		        }
	  			        else if (event.getAction() == MotionEvent.ACTION_UP) {
	  		          release = System.currentTimeMillis();
	  		          keyhold=release-press;
	  		  		System.out.println(buttonText+keyhold);
	  		  		r.addElement(release);
	  		  		addText(v);
	  		  		//disp(buttonText+keyhold);
	  		  		
	  		  		}
	  					
	  			 return true;
	  		     }
	  		    
	  		  });
	  		
	  		//y
	  		mB[24].setOnTouchListener(new OnTouchListener() {
	  		     @Override
	  		     public boolean onTouch(View v, MotionEvent event) {
	  			
	  			String buttonText = (String)v.getTag();
	  			        if(event.getAction() == MotionEvent.ACTION_DOWN) {
	  		           press = System.currentTimeMillis();
	  		           text.addElement(buttonText);
	  		           p.addElement(press);
	  		        }
	  			        else if (event.getAction() == MotionEvent.ACTION_UP) {
	  		          release = System.currentTimeMillis();
	  		          keyhold=release-press;
	  		  		System.out.println(buttonText+keyhold);
	  		  		r.addElement(release);
	  		  		addText(v);
	  		  		//disp(buttonText+keyhold);
	  		  		
	  		  		}
	  					
	  			 return true;
	  		     }
	  		    
	  		  });
	  		
	  		//z
	  		mB[25].setOnTouchListener(new OnTouchListener() {
	  		     @Override
	  		     public boolean onTouch(View v, MotionEvent event) {
	  			
	  			String buttonText = (String)v.getTag();
	  			        if(event.getAction() == MotionEvent.ACTION_DOWN) {
	  		           press = System.currentTimeMillis();
	  		           text.addElement(buttonText);
	  		           p.addElement(press);
	  		        }
	  			        else if (event.getAction() == MotionEvent.ACTION_UP) {
	  		          release = System.currentTimeMillis();
	  		          keyhold=release-press;
	  		  		System.out.println(buttonText+keyhold);
	  		  		r.addElement(release);
	  		  		addText(v);
	  		  		//disp(buttonText+keyhold);
	  		  		
	  		  		}
	  					
	  			 return true;
	  		     }
	  		    
	  		  });
	  		
	//spacebar
	  		
	  		mBSpace.setOnTouchListener(new OnTouchListener() {
	  		     @Override
	  		     public boolean onTouch(View v, MotionEvent event) {
	  			
	  			String buttonText = (String)v.getTag();
	  			        if(event.getAction() == MotionEvent.ACTION_DOWN) {
	  		           press = System.currentTimeMillis();
	  		           text.addElement(buttonText);
	  		           p.addElement(press);
	  		        }
	  			        else if (event.getAction() == MotionEvent.ACTION_UP) {
	  		          release = System.currentTimeMillis();
	  		          keyhold=release-press;
	  		  		System.out.println(buttonText+keyhold);
	  		  		r.addElement(release);
	  		  		addText(v);
	  		  		//disp(buttonText+keyhold);
	  		  		
	  		  		}
	  					
	  			 return true;
	  		     }
	  		    
	  		  });
	
	
	
	}
	 
	  		
	
	
	//h
	
	
	
	
	void disp(String t)
	{
		AlertDialog.Builder ald=new AlertDialog.Builder(this);
		ald.setMessage(t+"");
		ald.setPositiveButton("OK",null);
		ald.setCancelable(true);
		ald.create().show();
		ald.setPositiveButton("OK",new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int arg1) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	
	void done()
	{
		String v=mEt.getText().toString();
		
		if(password.equals(v)&&isTrainPressed)
		{
			
		trainpress--;
		op=text.toString();
		op+="\n";
		op+=p.toString();
		op+="\n";
		op+=r.toString();
		//disp(op);
		for(int j=0;j<text.size();j++)
			kh.addElement(r.elementAt(j)-p.elementAt(j));
		for(int i=0;i<text.size()-1;i++)
		{
			p2p1.addElement(p.get(i+1)-p.get(i));
			p2r1.addElement(p.get(i+1)-r.get(i));
			r2r1.addElement(r.get(i+1)-r.get(i));
		}
		String temp;
		 op="";
		temp=kh.toString();
		op+=temp.substring(1, temp.length()-1);
		op+=",";
		
		temp=p2p1.toString();
		op+=temp.substring(1, temp.length()-1);
		op+=",";
		
		temp=p2r1.toString();
		op+=temp.substring(1, temp.length()-1);
		op+=",";
		
		
		temp=r2r1.toString();
		op+=temp.substring(1, temp.length()-1);
		
		op="{"+op+"}\n";
		disp(op);
		try {
			
			fos.write(op.getBytes());
			//fos.close();
		//	disp("yolo");
			}
			catch(Exception e){}
		try {
			//fis=openFileInput(filename);
			//disp("reading");
			
			//br=new BufferedReader(new InputStreamReader(fis));
			//while((str=br.readLine())!=null)
				;//disp(str);
			//fis.close();
			}
			catch(Exception e){}
		int t=trainpress+1;
		disp(t+" times more");
		if(trainpress==0)
		{
			isTrainPressed=false;
			maketrainvisible();
			
		}
		
		}
		
		else if(password.equals(v)&&!isTrainPressed)
		{
			
			
			
			
			for(int j=0;j<text.size();j++)
				kh.addElement(r.elementAt(j)-p.elementAt(j));
			for(int i=0;i<text.size()-1;i++)
			{
				p2p1.addElement(p.get(i+1)-p.get(i));
				p2r1.addElement(p.get(i+1)-r.get(i));
				r2r1.addElement(r.get(i+1)-r.get(i));
			}
			String temp;
			 op="";
			temp=kh.toString();
			op+=temp.substring(1, temp.length()-1);
			op+=",";
			
			temp=p2p1.toString();
			op+=temp.substring(1, temp.length()-1);
			op+=",";
			
			temp=p2r1.toString();
			op+=temp.substring(1, temp.length()-1);
			op+=",";
			
			
			temp=r2r1.toString();
			op+=temp.substring(1, temp.length()-1);
			int t=0;
			op="{"+op+"}\n";
			disp("op display"+op);
			int start,end;
			TEST_CASE=new double[1][37];
			
			for(int i=0;i<op.length();i++)
			{
				if((op.charAt(i)==',')||(op.charAt(i)=='{'))
				{
					start=i+1;
					end=i+1;
					while((op.charAt(end)!=',')&&(op.charAt(end)!='}'))
						end++;
					//disp(start+"    "+end+"\n");
					//disp(op.substring(start,end)+"\n");
				TEST_CASE[0][t++]=Double.parseDouble(op.substring(start, end));
					
					
				}
			}
			disp("test"+Arrays.toString(TEST_CASE));
			
			
			
			
			
			
			String str;
			String data="";
			try{
			fis=openFileInput(filename);
			//disp("reading");
			
			br=new BufferedReader(new InputStreamReader(fis));
			while((str=br.readLine())!=null)
				data+=str;
			fis.close();
			}
			catch(Exception e){}
			int row=0,col=0;
			disp(data);
			USER_CASES=new double[10][37];
			for(int i=0;i<data.length();i++)
			{
				if((data.charAt(i)==',')||(data.charAt(i)=='{'))
				{
					start=i+1;
					end=i+1;
					while((data.charAt(end)!=',')&&(data.charAt(end)!='}'))
						end++;
					//disp(start+"    "+end+"\n");
					//disp(data.substring(start,end)+"\n");
					USER_CASES[row][col]=Double.parseDouble(data.substring(start, end));
					col++;
					if(col==37)
					{
					row=0;
					col=0;}
				}
			}
			
			disp(Arrays.toString(USER_CASES[0]));
			 NUMBER_OF_USER_CASES=USER_CASES.length;  //13
		        NUMBER_OF_INPUTS=USER_CASES[0].length;  //37
		        NUMBER_OF_LETTERS=(NUMBER_OF_INPUTS+3)/4;
		        
		        MEAN = new double[NUMBER_OF_INPUTS];
		        STANDARD_DEVIATION =new double[NUMBER_OF_INPUTS];
		        //USER_CASES = new double[NUMBER_OF_INPUTS][NUMBER_OF_USER_CASES];
		        NEW_USE_CASE = new double[NUMBER_OF_INPUTS];

		        hits = new double[NUMBER_OF_USER_CASES];
		        deviation = new double[NUMBER_OF_USER_CASES];
		        for(int i=0;i<NUMBER_OF_INPUTS;i++)
		        {
		            for(int j=0;j<NUMBER_OF_USER_CASES;j++)
		            {
		                MEAN[i]+=USER_CASES[j][i];
		            }
		             MEAN[i]/=10;
		        }
		        disp(Arrays.toString(MEAN));
		        for(int i=0;i<NUMBER_OF_INPUTS;i++)
		        {
		            double sum=0;
		            for(int j=0;j<NUMBER_OF_USER_CASES;j++)
		            {
		               sum+=Math.pow(USER_CASES[j][i] - MEAN[i], 2);
		            }
		            sum/=NUMBER_OF_USER_CASES;
		            STANDARD_DEVIATION[i]=Math.sqrt(sum);
		        }
		        disp(Arrays.toString(STANDARD_DEVIATION));
		     
		        
		        
		        for(int i=0;i<NUMBER_OF_USER_CASES;i++)
		        {
		             for(int j=0;j<NUMBER_OF_INPUTS;j++)
		             {
		                 double max=MEAN[j] + (X*STANDARD_DEVIATION[j]);
		                 double min=MEAN[j] - (X*STANDARD_DEVIATION[j]);
		                 
		                 if(USER_CASES[i][j]>=min && USER_CASES[i][j]<=max)
		                     hits[i]++;
		                 
		             }
		             hits[i]/=NUMBER_OF_INPUTS;
		             
		        }
		        disp("HITS"+Arrays.toString(hits));
		        
		        
		        
		        for(int i=0;i<TEST_CASE.length;i++)
		        {
		             for(int j=0;j<TEST_CASE[i].length;j++)
		             {
		                 double max=MEAN[j] + (X*STANDARD_DEVIATION[j]);
		                 double min=MEAN[j] - (X*STANDARD_DEVIATION[j]);
		                 
		                 if(TEST_CASE[i][j]>=min && TEST_CASE[i][j]<=max)
		                     hits[i]++;
		             }
		             hits[i]/=NUMBER_OF_INPUTS;
		        }
		        disp(hits[0]+"hits");
		        
		        
		        for(int i=0;i<NUMBER_OF_USER_CASES;i++)
		        {
		             for(int j=0;j<NUMBER_OF_INPUTS;j++)
		             {
		                 deviation[i]+=Math.abs(MEAN[j]-USER_CASES[i][j])/MEAN[j];
		             }
		             deviation[i]/=NUMBER_OF_INPUTS;
		        }
		        disp("devinput"+Arrays.toString(deviation));
		        
		        
		        
		        
		        deviation = new double[TEST_CASE.length];
		        
		        for(int i=0;i<TEST_CASE.length;i++)
		        {
		             for(int j=0;j<TEST_CASE[i].length;j++)
		             {
		                 deviation[i]+=Math.abs(MEAN[j]-TEST_CASE[i][j])/MEAN[j];
		             }
		             deviation[i]/=NUMBER_OF_INPUTS;
		        }
		        disp("deviation"+deviation[0]);
		        
		        boolean accept=false;
		        if(hits[0]>=0.3&&hits[0]<=1)
		        {
		        	if(deviation[0]>=0.0&&deviation[0]<=15)
		        		accept=true;
		        }
		        
		        if(accept)
		        	disp("ACCEPTED");
		        else
		        	disp("REJECTED");
		        
		
		}
			
		
		
		
		
		text.removeAllElements();
		kh.removeAllElements();
		p.removeAllElements();
		r.removeAllElements();
		p2p1.removeAllElements();
		p2r1.removeAllElements();
		r2r1.removeAllElements();
		
		mEt.setText("");
	}
	
	
	
	@Override
	public boolean onTouch(View v, MotionEvent event) {
		if (v == mEt) {
			hideDefaultKeyboard();
			enableKeyboard();
			
		}
		
		

		
		
		return true;
	}
	
	 public void displayedittext(View view)
	    {
		 	isTrainPressed=true;
		 	trainpress=11;
	    	EditText t=(EditText) findViewById(R.id.xEt);
	    	t.setVisibility(View.VISIBLE);
	    	Button b=(Button) findViewById(R.id.train);
	    	b.setVisibility(View.INVISIBLE);
	    }	
	@Override
	public void onClick(View v) {

		if (v == mBChange) {

			if (mBChange.getTag().equals(mUpper)) {
				changeSmallLetters();
				changeSmallTags();
			} else if (mBChange.getTag().equals(mLower)) {
				changeCapitalLetters();
				changeCapitalTags();
			}

		} else if (v != mBdone && v != mBack && v != mBChange && v != mNum && v!=mB[26]) {
			addText(v);

		} else if (v == mBdone) {

			disableKeyboard();

		} else if (v == mBack) {
			isBack(v);
		}
		else if(v==mB[26])
		{
			done();
		}
		
		else if (v == mNum) {
			String nTag = (String) mNum.getTag();
			if (nTag.equals("num")) {
				changeSyNuLetters();
				changeSyNuTags();
				mBChange.setVisibility(Button.INVISIBLE);

			}
			if (nTag.equals("ABC")) {
				changeCapitalLetters();
				changeCapitalTags();
			}

		}

	}
	void maketrainvisible()
	{
		Button b=(Button)findViewById(R.id.train);
		b.setVisibility(View.VISIBLE);
	}
	@Override
	public void onFocusChange(View v, boolean hasFocus) {
		if (v == mEt && hasFocus == true) {
			isEdit = true;
			

		}
	}

	private void addText(View v) {
		if (isEdit == true) {
			String b = "";
			b = (String) v.getTag();
			if (b != null) {
				// adding text in Edittext
				mEt.append(b);

			}
		}

		

		}

	

	private void isBack(View v) {
		if (isEdit == true) {
			CharSequence cc = mEt.getText();
			if (cc != null && cc.length() > 0) {
				{
					mEt.setText("");
					text.removeAllElements();
					r.removeAllElements();
					p.removeAllElements();
					p2p1.removeAllElements();
					r2r1.removeAllElements();
					p2r1.removeAllElements();
					noofbs++;
					//mEt.append(cc.subSequence(0, cc.length() - 1));
				}

			}
		}

		
	}
	private void changeSmallLetters() {
		mBChange.setVisibility(Button.VISIBLE);
		for (int i = 0; i < mB.length; i++)
			mB[i].setText(sL[i]);
		//mNum.setTag("12#");
	}
	private void changeSmallTags() {
		for (int i = 0; i < mB.length; i++)
			mB[i].setTag(sL[i]);
		mBChange.setTag("lower");
		//mNum.setTag("num");
	}
	private void changeCapitalLetters() {
		mBChange.setVisibility(Button.VISIBLE);
		for (int i = 0; i < mB.length; i++)
			mB[i].setText(cL[i]);
		mBChange.setTag("upper");
		//mNum.setText("12#");

	}

	private void changeCapitalTags() {
		for (int i = 0; i < mB.length; i++)
			mB[i].setTag(cL[i]);
		//mNum.setTag("num");

	}

	private void changeSyNuLetters() {

		for (int i = 0; i < mB.length; i++)
			mB[i].setText(nS[i]);
		//mNum.setText("ABC");
	}

	private void changeSyNuTags() {
		for (int i = 0; i < mB.length; i++)
			mB[i].setTag(nS[i]);
		//mNum.setTag("ABC");
	}

	// enabling customized keyboard
	private void enableKeyboard() {

		mLayout.setVisibility(RelativeLayout.VISIBLE);
		mKLayout.setVisibility(RelativeLayout.VISIBLE);

	}

	// Disable customized keyboard
	private void disableKeyboard() {
		mLayout.setVisibility(RelativeLayout.INVISIBLE);
		mKLayout.setVisibility(RelativeLayout.INVISIBLE);

	}

	private void hideDefaultKeyboard() {
		getWindow().setSoftInputMode(
				WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

	}

	private void setFrow() {
		w = (mWindowWidth / 13);
		w = w - 15;
		mB[16].setWidth(w);
		mB[22].setWidth(w + 3);
		mB[4].setWidth(w);
		mB[17].setWidth(w);
		mB[19].setWidth(w);
		mB[24].setWidth(w);
		mB[20].setWidth(w);
		mB[8].setWidth(w);
		mB[14].setWidth(w);
		mB[15].setWidth(w);
		mB[16].setHeight(50);
		mB[22].setHeight(50);
		mB[4].setHeight(50);
		mB[17].setHeight(50);
		mB[19].setHeight(50);
		mB[24].setHeight(50);
		mB[20].setHeight(50);
		mB[8].setHeight(50);
		mB[14].setHeight(50);
		mB[15].setHeight(50);

	}

	private void setSrow() {
		w = (mWindowWidth / 10);
		mB[0].setWidth(w);
		mB[18].setWidth(w);
		mB[3].setWidth(w);
		mB[5].setWidth(w);
		mB[6].setWidth(w);
		mB[7].setWidth(w);
		mB[26].setWidth(w);
		mB[9].setWidth(w);
		mB[10].setWidth(w);
		mB[11].setWidth(w);
		//mB[26].setWidth(w);
		mBack.setWidth(w);
		mB[0].setHeight(50);
		mB[18].setHeight(50);
		mB[3].setHeight(50);
		mB[5].setHeight(50);
		mB[6].setHeight(50);
		mB[7].setHeight(50);
		mB[9].setHeight(50);
		mB[10].setHeight(50);
		mB[11].setHeight(50);
		mBack.setHeight(50);
	}

	private void setTrow() {
		w = (mWindowWidth / 12);
		mB[25].setWidth(w);
		mB[23].setWidth(w);
		mB[2].setWidth(w);
		mB[21].setWidth(w);
		mB[1].setWidth(w);
		mB[13].setWidth(w);
		mB[12].setWidth(w);
		//mB[27].setWidth(w);
		//mB[28].setWidth(w);
		//mBack.setWidth(w);
		mB[26].setWidth(w+w+w);
		mB[25].setHeight(50);
		mB[23].setHeight(50);
		mB[2].setHeight(50);
		mB[21].setHeight(50);
		mB[1].setHeight(50);
		mB[13].setHeight(50);
		mB[12].setHeight(50);
		//mB[27].setHeight(50);
		//mB[28].setHeight(50);
		//mBack.setHeight(50);
		mB[26].setHeight(50);

	}

	private void setForow() {
		w = (mWindowWidth / 10);
		mBSpace.setWidth(w * 8);
		mBSpace.setHeight(50);
		//mB[29].setWidth(w);
		//mB[29].setHeight(50);

		//mB[30].setWidth(w);
		//mB[30].setHeight(50);

		//mB[31].setHeight(50);
		//mB[31].setWidth(w);
		mBdone.setWidth(w);
		mBdone.setHeight(50);

	}

		private void setKeys() {
		
		Display display=getWindowManager().getDefaultDisplay();
		Point size=new Point();
		display.getSize(size);
		mWindowWidth = size.x; // getting
		// window
		// height
		// getting ids from xml files
		mB[0] = (Button) findViewById(R.id.xA);
		mB[1] = (Button) findViewById(R.id.xB);
		mB[2] = (Button) findViewById(R.id.xC);
		mB[3] = (Button) findViewById(R.id.xD);
		mB[4] = (Button) findViewById(R.id.xE);
		mB[5] = (Button) findViewById(R.id.xF);
		mB[6] = (Button) findViewById(R.id.xG);
		mB[7] = (Button) findViewById(R.id.xH);
		mB[8] = (Button) findViewById(R.id.xI);
		mB[9] = (Button) findViewById(R.id.xJ);
		mB[10] = (Button) findViewById(R.id.xK);
		mB[11] = (Button) findViewById(R.id.xL);
		mB[12] = (Button) findViewById(R.id.xM);
		mB[13] = (Button) findViewById(R.id.xN);
		mB[14] = (Button) findViewById(R.id.xO);
		mB[15] = (Button) findViewById(R.id.xP);
		mB[16] = (Button) findViewById(R.id.xQ);
		mB[17] = (Button) findViewById(R.id.xR);
		mB[18] = (Button) findViewById(R.id.xS);
		mB[19] = (Button) findViewById(R.id.xT);
		mB[20] = (Button) findViewById(R.id.xU);
		mB[21] = (Button) findViewById(R.id.xV);
		mB[22] = (Button) findViewById(R.id.xW);
		mB[23] = (Button) findViewById(R.id.xX);
		mB[24] = (Button) findViewById(R.id.xY);
		mB[25] = (Button) findViewById(R.id.xZ);
		mB[26] = (Button) findViewById(R.id.xS1);
		//mB[27] = (Button) findViewById(R.id.xS2);
		//mB[28] = (Button) findViewById(R.id.xS3);
		//mB[29] = (Button) findViewById(R.id.xS4);
		//mB[30] = (Button) findViewById(R.id.xS5);
		//mB[31] = (Button) findViewById(R.id.xS6);
		mBSpace = (Button) findViewById(R.id.xSpace);
		mBdone = (Button) findViewById(R.id.xDone);
		mBChange = (Button) findViewById(R.id.xChange);
		mBack = (Button) findViewById(R.id.xBack);
		//mNum = (Button) findViewById(R.id.xNum);
		for (int i = 0; i < mB.length; i++)
			mB[i].setOnClickListener(this);
		mBSpace.setOnClickListener(this);
		mBdone.setOnClickListener(this);
		mBack.setOnClickListener(this);
		mBChange.setOnClickListener(this);
		//mNum.setOnClickListener(this);

	}

}