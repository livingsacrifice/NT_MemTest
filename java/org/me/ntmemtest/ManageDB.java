 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.me.ntmemtest;

//import org.me.ntmemtest.NT_MemTest.ProgressThread;
//import org.me.ntmemtest.NT_MemTest.ProgressThread;
import org.me.ntmemtest.util.*;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.*;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
//import android.net.*;
import java.io.*;
//import java.util.zip.*;
import java.util.*;

/**
 *
 * @author srichard
 */
public class ManageDB extends Activity {
    private MyApplication application;
    //private DataBaseHelper myDbHelper;
    private Button exportDbToSdButton;
    private Button importDbFromSdButton;
    private Button clearDbButton;
    private Button uploadButton;
    private Button clearBibleButton;
    private Button VersesToCSVButton;
    private Button ClearScoresButton;
    //private Button downloadButton;
    String version;
    public DataBaseHelper myDbHelper;
    //private Button showStatsButton;
    public NT_MemTest main1;
    ProgressThread progThread;
    ProgressDialog progDialog;
    boolean alertCancel;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // ToDo add your GUI initialization code here
        application = (MyApplication) getApplication();

      setContentView(R.layout.managedata);
      //main1 = new NT_MemTest(this);
      exportDbToSdButton = (Button) findViewById(R.id.exportdbtosdbutton);
      exportDbToSdButton.setOnClickListener(new OnClickListener() {
         public void onClick(final View v) {
            Log.i("Database", "exporting database to external storage");
            new AlertDialog.Builder(ManageDB.this).setMessage(
                     "Are you sure (this will overwrite any existing backup data)?").setPositiveButton("Yes",
                     new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface arg0, int arg1) {
                           if (isExternalStorageAvail()) {
                              Log.i("Database", "exporting database to external storage");
                              new ExportDatabaseTask().execute();
                              //ManageDB.this.startActivity(new Intent(ManageDB.this, NT_MemTest.class));
                           } else {
                              Toast.makeText(ManageDB.this,
                                       "External storage is not available, unable to export data.", Toast.LENGTH_SHORT)
                                       .show();
                           }
                        }
                     }).setNegativeButton("No", new DialogInterface.OnClickListener() {
               public void onClick(DialogInterface arg0, int arg1) {
               }
            }).show();
         }
      });

      importDbFromSdButton = (Button) findViewById(R.id.importdbfromsdbutton);
      importDbFromSdButton.setOnClickListener(new OnClickListener() {
         public void onClick(final View v) {
            new AlertDialog.Builder(ManageDB.this).setMessage(
                     "Are you sure (this will overwrite existing current data)?").setPositiveButton("Yes",
                     new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface arg0, int arg1) {
                           if (isExternalStorageAvail()) {
                              Log.i("Database", "importing database from external storage, and resetting database");
                              new ImportDatabaseTask().execute();
                              // sleep momentarily so that database reset stuff has time to take place (else Main reloads too fast)
                              SystemClock.sleep(500);
                              ManageDB.this.startActivity(new Intent(ManageDB.this, NT_MemTest.class));
                           } else {
                              Toast.makeText(ManageDB.this,
                                       "External storage is not available, unable to export data.", Toast.LENGTH_SHORT)
                                       .show();
                           }
                        }
                     }).setNegativeButton("No", new DialogInterface.OnClickListener() {
               public void onClick(DialogInterface arg0, int arg1) {
               }
            }).show();
         }
      });

      clearDbButton = (Button) findViewById(R.id.cleardbutton);
      clearDbButton.setOnClickListener(new OnClickListener() {
         public void onClick(final View v) {

            new AlertDialog.Builder(ManageDB.this).setMessage("Are you sure (this will delete all data)?")
                     .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface arg0, int arg1) {
                           Log.i("Database", "deleting database");
                           ManageDB.this.application.getDataHelper().deleteAllDataYesIAmSure();
                           ManageDB.this.application.getDataHelper().resetDbConnection();
                           Toast.makeText(ManageDB.this, "Data deleted", Toast.LENGTH_SHORT).show();
                           ManageDB.this.startActivity(new Intent(ManageDB.this, NT_MemTest.class));
                        }
                     }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface arg0, int arg1) {
                        }
                     }).show();
         }
      });
      
      Spinner spinner5 = (Spinner) findViewById(R.id.sVersionTwo);
      ArrayAdapter<CharSequence> adapter5 = ArrayAdapter.createFromResource(
              this, R.array.version_list, android.R.layout.simple_spinner_item);
      adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
      spinner5.setAdapter(adapter5);
      spinner5.setOnItemSelectedListener(new VersionOnItemSelectedListener());
      spinner5.setSelection(1);
      
      /*downloadButton = (Button) findViewById(R.id.downloadbutton);
      downloadButton.setOnClickListener(new OnClickListener() {
         public void onClick(final View v) {

            new AlertDialog.Builder(ManageDB.this).setMessage("Confirm download of selected version?")
                     .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface arg0, int arg1) {
                           ManageDB.this.startActivity(new Intent(ManageDB.this, NT_MemTest.class));
                        	if (version.equals("HCSB")){
                        		Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://mega.co.nz/#!5NBn2Yaa!I8v_hXujm2sj4oUhMZPj4AqUy_VYnRZnCSvrsj6fidg"));
                        		startActivity(browserIntent);
                        	}
                        
                        }
                     }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface arg0, int arg1) {
                        }
                     }).show();
         }
      });*/
      
      uploadButton = (Button) findViewById(R.id.uploadbutton);
      uploadButton.setOnClickListener(new OnClickListener() {
         public void onClick(final View v) {
        	 new AlertDialog.Builder(ManageDB.this).setMessage("This process could take several minutes. Continue?")
             .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface arg0, int arg1) {
                	alertCancel = false;
                	showDialog(0);
                }
             }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface arg0, int arg1) {
                }
             }).show();
        	 
         }
      });
      
      clearBibleButton = (Button) findViewById(R.id.clearbiblebutton);
      clearBibleButton.setOnClickListener(new OnClickListener() {
         public void onClick(final View v) {

            new AlertDialog.Builder(ManageDB.this).setMessage("Are you sure (this will clear all bibles)?")
                     .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface arg0, int arg1) {
                           Log.i("Database", "deleting biles from database");
                           ManageDB.this.application.getDataHelper().deleteAllBiblesYesIAmSure();
                           ManageDB.this.application.getDataHelper().resetDbConnection();
                           Toast.makeText(ManageDB.this, "Bibles deleted", Toast.LENGTH_SHORT).show();
                           ManageDB.this.startActivity(new Intent(ManageDB.this, NT_MemTest.class));
                        }
                     }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface arg0, int arg1) {
                        }
                     }).show();
         }
      });
      
      VersesToCSVButton = (Button) findViewById(R.id.versestocsvbutton);
      VersesToCSVButton.setOnClickListener(new OnClickListener() {
         public void onClick(final View v) {

            new AlertDialog.Builder(ManageDB.this).setMessage("Are you sure (this will create or overwrite /sdcard/myverses.csv)?")
                     .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface arg0, int arg1) {
                        	if (isExternalStorageAvail()) {
                                Log.i("Database", "exporting verses table to csv file");
                                new ExportDatabaseTable().execute();
                                //ManageDB.this.startActivity(new Intent(ManageDB.this, NT_MemTest.class));
                             } else {
                                Toast.makeText(ManageDB.this,
                                         "External storage is not available, unable to export data.", Toast.LENGTH_SHORT)
                                         .show();
                             }
                        }
                     }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface arg0, int arg1) {
                        }
                     }).show();
         }
      });
      
      ClearScoresButton = (Button) findViewById(R.id.clearscoresbutton);
      ClearScoresButton.setOnClickListener(new OnClickListener() {
         public void onClick(final View v) {

            new AlertDialog.Builder(ManageDB.this).setMessage("Are you sure (this will reset scores to zero)?")
                     .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface arg0, int arg1) {
                        	myDbHelper.clearScores();
                        	Log.i("Database", "clearing all plus and minus values");
                        	Toast.makeText(ManageDB.this,"Scores set to zero.", Toast.LENGTH_SHORT).show();
                        	ManageDB.this.startActivity(new Intent(ManageDB.this, NT_MemTest.class));
                        }
                     }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface arg0, int arg1) {
                        }
                     }).show();
         }
      });
      
      myDbHelper = new DataBaseHelper(this);
      try {
      	myDbHelper.createDataBase();
	 	} catch (IOException ioe) {
	 		throw new Error("Unable to create database");
	 	}

    }
    private boolean isExternalStorageAvail() {
      return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
       
   }
    
    // Method to create a progress bar dialog of either spinner or horizontal type
    @Override
    protected Dialog onCreateDialog(int id) {

            progDialog = new ProgressDialog(this);
            progDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            progDialog.setMax(12);
            progDialog.setMessage("Inserting verses into database:");
            progThread = new ProgressThread(handler);
            progThread.start();
            return progDialog;

    }
    
 // Handler on the main (UI) thread that will receive messages from the 
    // second thread and update the progress.
    
    final Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            // Get the current value of the variable total from the message data
            // and update the progress bar.
            int total = msg.getData().getInt("total");
            progDialog.setProgress(total);
            if (total >= 12){
            	alertCancel = true;
                removeDialog(0);
                progThread.setState(ProgressThread.DONE);
            }
        }
    };

   private class ExportDatabaseTask extends AsyncTask<Void, Void, Boolean> {
      private final ProgressDialog dialog = new ProgressDialog(ManageDB.this);

      // can use UI thread here
      @Override
      protected void onPreExecute() {
         dialog.setMessage("Exporting database...");
         dialog.show();
      }

      // automatically done on worker thread (separate from UI thread)
      @Override
      protected Boolean doInBackground(final Void... args) {

         File dbFile = new File(Environment.getDataDirectory() + "/data/org.me.ntmemtest/databases/mem_verses");

         File exportDir = new File(Environment.getExternalStorageDirectory(), "databasedata");
         if (!exportDir.exists()) {
            exportDir.mkdirs();
         }
         File file = new File(exportDir, dbFile.getName());

         try {
            file.createNewFile();
            FileUtil.copyFile(dbFile, file);
            return true;
         } catch (IOException e) {
            Log.e("Database", e.getMessage(), e);
            return false;
         }
      }

      // can use UI thread here
      @Override
      protected void onPostExecute(final Boolean success) {
         if (dialog.isShowing()) {
            dialog.dismiss();
         }
         if (success) {
            Toast.makeText(ManageDB.this, "Export successful!", Toast.LENGTH_SHORT).show();
         } else {
            Toast.makeText(ManageDB.this, "Export failed", Toast.LENGTH_SHORT).show();
         }
      }
   }
   
   private class ExportDatabaseTable extends AsyncTask<Void, Void, Boolean> {
	      private final ProgressDialog dialog = new ProgressDialog(ManageDB.this);

	      // can use UI thread here
	      @Override
	      protected void onPreExecute() {
	         dialog.setMessage("Exporting verses to CSV...");
	         dialog.show();
	      }

	      // automatically done on worker thread (separate from UI thread)
	      @Override
	      protected Boolean doInBackground(final Void... args) {

	         /*File dbFile = new File(Environment.getDataDirectory() + "/data/org.me.ntmemtest/databases/mem_verses");

	         File exportDir = new File(Environment.getExternalStorageDirectory(), "databasedata");
	         if (!exportDir.exists()) {
	            exportDir.mkdirs();
	         }
	         File file = new File(exportDir, dbFile.getName());

	         try {
	            file.createNewFile();
	            FileUtil.copyFile(dbFile, file);
	            return true;
	         } catch (IOException e) {
	            Log.e("Database", e.getMessage(), e);
	            return false;
	         }*/
	    	 boolean testx = false;
	    	 try{
	    		testx = myDbHelper.versesToCSV();
	    	 } catch (IOException ex) {
	          // LOG or output exception
	          System.out.println(ex);
	          testx = false;
	    	 }
	    	 finally {
	     		
	     	}
	    	  return testx;
	      }

	      // can use UI thread here
	      @Override
	      protected void onPostExecute(final Boolean success) {
	         if (dialog.isShowing()) {
	            dialog.dismiss();
	         }
	         if (success) {
	            Toast.makeText(ManageDB.this, "Export successful!", Toast.LENGTH_SHORT).show();
	         } else {
	            Toast.makeText(ManageDB.this, "Export failed", Toast.LENGTH_SHORT).show();
	         }
	      }
	   }

   private class ImportDatabaseTask extends AsyncTask<Void, Void, String> {
      private final ProgressDialog dialog = new ProgressDialog(ManageDB.this);

      @Override
      protected void onPreExecute() {
         dialog.setMessage("Importing database...");
         dialog.show();
      }

      // could pass the params used here in AsyncTask<String, Void, String> - but not being re-used
      @Override
      protected String doInBackground(final Void... args) {

         File dbBackupFile = new File(Environment.getExternalStorageDirectory() + "/databasedata/mem_verses");
         if (!dbBackupFile.exists()) {
            return "Database backup file does not exist, cannot import.";
         } else if (!dbBackupFile.canRead()) {
            return "Database backup file exists, but is not readable, cannot import.";
         }

         File dbFile = new File(Environment.getDataDirectory() + "/data/org.me.ntmemtest/databases/mem_verses");
         if (dbFile.exists()) {
            dbFile.delete();
         }

         try {
            dbFile.createNewFile();
            FileUtil.copyFile(dbBackupFile, dbFile);
            //ManageDB.this.application.getDataHelper().resetDbConnection();
            return null;
         } catch (IOException e) {
            Log.e("Database", e.getMessage(), e);
            return e.getMessage();
         }
      }

      @Override
      protected void onPostExecute(final String errMsg) {
         if (dialog.isShowing()) {
            dialog.dismiss();
         }
         if (errMsg == null) {
            Toast.makeText(ManageDB.this, "Import successful!", Toast.LENGTH_SHORT).show();
         } else {
            Toast.makeText(ManageDB.this, "Import failed - " + errMsg, Toast.LENGTH_SHORT).show();
         }
      }
   }
   public class VersionOnItemSelectedListener implements AdapterView.OnItemSelectedListener {

       public void onItemSelected(AdapterView<?> parent,
           View view, int pos, long id) {
           version = parent.getItemAtPosition(pos).toString();
       }

       public void onNothingSelected(AdapterView parent) {
         // Do nothing.
       }
   }
   
   private class ProgressThread extends Thread {	
       
       // Class constants defining state of the thread
       final static int DONE = 0;
       final static int RUNNING = 1;
       
       Handler mHandler;
       int mState;
       int total;
       int countAdd = 0;
       //int i = 1;
       //int j = 1;
       //boolean verseDict;
       // Constructor with an argument that specifies Handler on main thread
       // to which messages will be sent by this thread.
       
       ProgressThread(Handler h) {
           mHandler = h;
       }
       
       // Override the run() method that will be invoked automatically when 
       // the Thread starts.  Do the work required to update the progress bar on this
       // thread but send a message to the Handler on the main UI thread to actually
       // change the visual representation of the progress. In this example we count
       // the index total down to zero, so the horizontal progress bar will start full and
       // count down.
       
       @Override
       public void run() {
           mState = RUNNING;   
           total = 0;           
           String[] letters = {"a","b","c","d","e","f"};
           while (mState == RUNNING) {
        	  try{ 
	      	 int versionCount = myDbHelper.checkBibleVersion(version);
	  		 if (versionCount == 31102){
	  			//version already stored 
	  			 /*if (alertCancel){
	  			 new AlertDialog.Builder(ManageDB.this).setMessage(
	          			 "This translation is already cached.").setPositiveButton("OK",
	                       new DialogInterface.OnClickListener() {
	                          public void onClick(DialogInterface arg0, int arg1) {
	
	                          }
	                       }).show();
	  			 
	  			 }*/
	  			total = 12;
	  			Message msg = mHandler.obtainMessage();
	               Bundle b = new Bundle();
	               b.putInt("total", total);
	               msg.setData(b);
	               mHandler.sendMessage(msg);
	  		 }
	  		 else {
	  			 if (versionCount > 0){
	  				//version only partially stored. then continue
	  				 myDbHelper.resetBibleVersion(version);
	  			 }
	  			 AssetManager assetManager = getResources().getAssets();
	  			 InputStream inputStream = null;
				     try {
				    	// Control speed of update (but precision of delay not guaranteed)
		                   Thread.sleep(25);
				    	 //long startTime = System.nanoTime();
				    	 for (int j = 0; j < letters.length; j++){
					    	 inputStream = assetManager.open(version.toLowerCase() + "_verses_" + letters[j] + ".csv");
				             if ( inputStream != null){
				            	 //long startTime = System.nanoTime(); 
				            	 //myDbHelper.beginTrans();
				            	 BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
				            	 String line = null;
				            	 Vector<String> insertList = new Vector<String>();
				            	 while((line = reader.readLine()) != null)
				                 {
				                     //get verse from comma separated line
				            		 Vector<String> store = new Vector<String>();
				            		 StringBuffer curVal = new StringBuffer();
				            		 boolean inquotes = false;
				            		 for (int i=0; i<line.length(); i++) {
				            	            char ch = line.charAt(i);
				            	            if (inquotes) {
				            	                if (ch=='\"') {
				            	                    inquotes = false;
				            	                }
				            	                else {
				            	                	curVal.append(ch);
				            	                	if (ch=='\''){
				            	                		curVal.append(ch);
				            	                	}
				            	                }
				            	            }
				            	            else {
				            	                if (ch=='\"') {
				            	                    inquotes = true;
				            	                    if (curVal.length()>0) {
									            	//if this is the second quote in a value, add a quote
									            	//this is for the double quote in the middle of a value
				            	                        curVal.append('\"');
				            	                    }
				            	                }
				            	                else if (ch==',') {
				            	                    store.add(curVal.toString());
				            	                    curVal = new StringBuffer();
				            	                }
				            	                else {
				            	                    curVal.append(ch);
				            	                    if (ch=='\''){
				            	                		curVal.append(ch);
				            	                	}
				            	                }
				            	            }
				            	        }
				            	        store.add(curVal.toString());
				            	        //upload verse
				            	        String bookx = store.get(0).toString();
				            	        int chapterx = Integer.parseInt(store.get(1).toString());
				            	        int versex = Integer.parseInt(store.get(2).toString());
				            	        String wordsx = store.get(3).toString();
				            	        insertList.add("insert into bible (book, chapter, verse, version, words) "
				            	                + "values ('" + bookx + "', " + chapterx + ", " + versex + ",'" + version + "','" + wordsx + "')");
				                 }
				            	 total++;
				            	 Message msg = mHandler.obtainMessage();
				                 Bundle b = new Bundle();
				                 b.putInt("total", total);
				                 msg.setData(b);
				                 mHandler.sendMessage(msg);
				                 
				            	 myDbHelper.batchInsert(insertList);
				            	 
				            	 total++;
				            	 msg = mHandler.obtainMessage();
				                 b = new Bundle();
				                 b.putInt("total", total);
				                 b.putInt("countAdd",countAdd);
				                 msg.setData(b);
				                 mHandler.sendMessage(msg);
				             }
				             
			             }    			  
				    	 //long estimatedTime = System.nanoTime() - startTime;
		            	 //double elapse1 = Math.floor(estimatedTime/1000000000);
		            	 //Toast.makeText(ManageDB.this,"Success! Process took " + elapse1 + "sec.", Toast.LENGTH_LONG);
		            	 /*new AlertDialog.Builder(ManageDB.this).setMessage(
		            			 "Success! Process took " + elapse1 + "sec.").setPositiveButton("OK",
		                         new DialogInterface.OnClickListener() {
		                            public void onClick(DialogInterface arg0, int arg1) {
	
		                            }
		                         }).show();*/
			         } catch (IOException e) {
			             e.printStackTrace();
			         }
	  		 		}
        	  } catch (InterruptedException e) {
                  //Log.e("ERROR", "Thread was Interrupted");
              }
           }
           /*while (mState == RUNNING) {
               // The method Thread.sleep throws an InterruptedException if Thread.interrupt() 
               // were to be issued while thread is sleeping; the exception must be caught.
               try {
                   // Control speed of update (but precision of delay not guaranteed)
                   Thread.sleep(25);
                   
                   
                   
               } catch (InterruptedException e) {
                   //Log.e("ERROR", "Thread was Interrupted");
               }
               
               // Send message (with current value of  total as data) to Handler on UI thread
               // so that it can update the progress bar.
               
               Message msg = mHandler.obtainMessage();
               Bundle b = new Bundle();
               b.putInt("total", total);
               b.putInt("countAdd",countAdd);
               msg.setData(b);
               mHandler.sendMessage(msg);
               
               total--;    // Count down
           }*/
       }
       
       // Set current state of thread (use state=ProgressThread.DONE to stop thread)
       public void setState(int state) {
           mState = state;
       }
   }
}