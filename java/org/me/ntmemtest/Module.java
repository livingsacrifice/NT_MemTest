/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.me.ntmemtest;

import java.util.Random;

/**
 *
 * @author srichard
 */
public class Module {
    public static String check1(String versionx, String book, int chapter, int verse){
        String versetext = "";
        boolean NTcheck = false;
        if (book.equals("Matthew") || book.equals("Mark") || book.equals("Luke") || book.equals("John")
        		 || book.equals("Acts") || book.equals("Romans") || book.equals("1 Corinthians") || book.equals("2 Corinthians")
        		 || book.equals("Galatians") || book.equals("Ephesians") || book.equals("Philippians") || book.equals("Colossians")
        		 || book.equals("1 Thessalonians") || book.equals("2 Thessalonians") || book.equals("1 Timothy") || book.equals("2 Timothy")
        		 || book.equals("Titus") || book.equals("Philemon") || book.equals("Hebrews") || book.equals("James")
        		 || book.equals("1 Peter") || book.equals("2 Peter") || book.equals("1 John") || book.equals("2 John")
        		 || book.equals("3 John") || book.equals("Judex") || book.equals("Revelation")){
        	NTcheck = true;
        }
        if (versionx.equals("KJV") && NTcheck){
            String[][] chap = new String [1][1];
            if (book.equals("Matthew")){
                chap = books.Matthew.chap(versionx);
            }
            else if (book.equals("Mark")){
                 chap = books.Mark.chap(versionx);
            }
            else if (book.equals("Luke")){
                 chap = books.Luke.chap(versionx);
            }
            else if (book.equals("John")){
                 chap = books.John.chap(versionx);
            }
            else if (book.equals("Acts")){
                 chap = books.Acts.chap(versionx);
            }
            else if (book.equals("Romans")){
                 chap = books.Romans.chap(versionx);
            }
            else if (book.equals("1 Corinthians")){
                 chap = books.a_1_Corinthians.chap(versionx);
            }
            else if (book.equals("2 Corinthians")){
                 chap = books.a_2_Corinthians.chap(versionx);
            }
            else if (book.equals("Galatians")){
                 chap = books.Galatians.chap(versionx);
            }
            else if (book.equals("Ephesians")){
                 chap = books.Ephesians.chap(versionx);
            }
            else if (book.equals("Philippians")){
                 chap = books.Philippians.chap(versionx);
            }
            else if (book.equals("Colossians")){
                 chap = books.Colossians.chap(versionx);
            }
            else if (book.equals("1 Thessalonians")){
                 chap = books.a_1_Thessalonians.chap(versionx);
            }
            else if (book.equals("2 Thessalonians")){
                 chap = books.a_2_Thessalonians.chap(versionx);
            }
            else if (book.equals("1 Timothy")){
                 chap = books.a_1_Timothy.chap(versionx);
            }
            else if (book.equals("2 Timothy")){
                 chap = books.a_2_Timothy.chap(versionx);
            }
            else if (book.equals("Titus")){
                 chap = books.Titus.chap(versionx);
            }
            else if (book.equals("Philemon")){
                 chap = books.Philemon.chap(versionx);
            }
            else if (book.equals("Hebrews")){
                 chap = books.Hebrews.chap(versionx);
            }
            else if (book.equals("James")){
                 chap = books.James.chap(versionx);
            }
            else if (book.equals("1 Peter")){
                 chap = books.a_1_Peter.chap(versionx);
            }
            else if (book.equals("2 Peter")){
                 chap = books.a_2_Peter.chap(versionx);
            }
            else if (book.equals("1 John")){
                 chap = books.a_1_John.chap(versionx);
            }
            else if (book.equals("2 John")){
                 chap = books.a_2_John.chap(versionx);
            }
            else if (book.equals("3 John")){
                 chap = books.a_3_John.chap(versionx);
            }
            else if (book.equals("Jude")){
                 chap = books.Jude.chap(versionx);
            }
            else if (book.equals("Revelation")){
                 chap = books.Revelation.chap(versionx);
            }
            if (chap[chapter][verse] != null){
                versetext = chap[chapter][verse];
            }
             else {
                 versetext = "Scripture not loaded.";
             }
        }
        /*else if (versionx.equals("NIV")){
            versetext = "Version not implemented.";
        }*/
        else{
        	versetext = "Bible version not cached. Please cache from menu -> database -> cache selected version.";
            /*try{
                //get verse from website
                String bookx = book;
                if (book.substring(0,1).equals("1") || book.substring(0,1).equals("2") || book.substring(0,1).equals("3")){
                    bookx = book.substring(0,1) + "%20" + book.substring(2,book.length());
                }
                if (book.length() >= 4){
	                if (book.substring(0,4).equals("Song")){
	                	bookx = "Song" + "%20" + "of" + "%20" + "Solomon";
	                }
                }
                String sHtml = JavaGetUrl.GetURL("http://www.biblegateway.com/passage/?search=" + bookx + "%20" + chapter + ":" + verse + "&version=" + versionx);
                //parse html for the passage
                boolean ignore_flag = false;
                String verse1 = "";
                outerLoop:
                for (int i = 0; i <= sHtml.length() - 14; i++){
                	if (sHtml.substring(i,i+14).equals("og:description")){
                		for (int j = i + 25; j <= sHtml.length(); j++){
                			if (sHtml.substring(j,j+3).equals('\"' + "/>")){
                				//verse complete
                				break outerLoop;
                			}
                			verse1 += sHtml.substring(j,j+1);
                		}
                	}
                }
                //String verse1 = JavaGetUrl.GetURLdesc("www.biblegateway.com/passage/?search=" + bookx + " " + chapter + ":" + verse + "&version=" + versionx);
                //String verse1 = JavaGetUrl.GetURLdesc(bookx,chapter,verse,versionx);
                /*if (versionx.equals("NASBx") || versionx.equals("HCSBx") || versionx.equals("NIVx")){
                    outerLoop:
                    for (int i = 0; i <= sHtml.length() -14; i++){
                        if (sHtml.substring(i,i+10).equals('\"' + "versenum" + '\"')){
                            for (int j = i; j <= sHtml.length() -14; j++){
                                if (sHtml.substring(j,j+6).equals("</sup>")){
                                    j += 6;
                                    if (versionx.equals("NASB") || versionx.equals("HCSB") || versionx.equals("NIV")){
                                        for (int k = j; k <= sHtml.length() -14; k ++){
                                            if (verse > 1){
                                                //k += 6;
                                                for (int l = k; l <= sHtml.length() - 14; l++) {
                                                    if (sHtml.substring(l,l+6).equals("><p />")){
                                                        l += 6;
                                                    }
                                                    if (sHtml.substring(l,l+4).equals("><p>")){
                                                        l += 4;
                                                    }
                                                    while (sHtml.substring(l,l+6).equals("&nbsp;")){
                                                        l += 6;
                                                    }
                                                    if (sHtml.substring(l,l+6).equals("</sup>")){
                                                        ignore_flag = false;
                                                        l += 6;
                                                    }
                                                    if (sHtml.substring(l,l+4).equals("<sup")){
                                                        verse1 += " ";
                                                        ignore_flag = true;
                                                        l += 4;
                                                    }
                                                    if (sHtml.substring(l,l+5).equals("</h4>")){
                                                        ignore_flag = false;
                                                        l += 5;
                                                    }
                                                    if (sHtml.substring(l,l+3).equals("<h4")){
                                                        verse1 += " ";
                                                        ignore_flag = true;
                                                        l += 3;
                                                    }
                                                    if (sHtml.substring(l,l+5).equals("</h5>")){
                                                        ignore_flag = false;
                                                        l += 5;
                                                    }
                                                    if (sHtml.substring(l,l+3).equals("<h5")){
                                                        verse1 += " ";
                                                        ignore_flag = true;
                                                        l += 3;
                                                    }
                                                    if (sHtml.substring(l,l+6).equals("</sup>")){
                                                        ignore_flag = false;
                                                        l += 6;
                                                    }
                                                    if (sHtml.substring(l,l+4).equals("<sup")){
                                                        verse1 += " ";
                                                        ignore_flag = true;
                                                        l += 4;
                                                    }
                                                    boolean redo1 = true;
                                                    while (redo1) {
                                                       if (sHtml.substring(l,l+3).equals("<i>")){
                                                           verse1 += " ";
                                                           l += 3;
                                                       }
                                                       else if(sHtml.substring(l, l + 4).equals("</i>"))
                                                       {
                                                           verse1 += " ";
                                                           l += 4;
                                                       }
                                                        else if (sHtml.substring(l, l + 6).equals("<br />")) {
                                                           verse1 += " ";
                                                           l += 6;
                                                       }
                                                       else {
                                                           redo1 = false;
                                                       }
                                                    }
                                                    if (sHtml.substring(l,l+5).equals("<font")){
                                                        boolean redo2 = true;
                                                        while (redo2) {
                                                           if (sHtml.substring(l,l+1).equals(">")){
                                                               redo2 = false;
                                                           }
                                                           l += 1;
                                                        }
                                                    }
                                                    if (sHtml.substring(l,l+7).equals("</font>")){
                                                        l += 7;
                                                    }
                                                    if (sHtml.substring(l,l+1).equals("*")){
                                                        l += 1;
                                                    }
                                                    if (sHtml.substring(l,l+5).equals("<p />")){
                                                        l += 5;
                                                    }
                                                    if (sHtml.substring(l,l+6).equals("&nbsp;")){
                                                        l += 6;
                                                    }
                                                    if (sHtml.substring(l,l+6).equals("</sup>")){
                                                        ignore_flag = false;
                                                        l += 6;
                                                    }
                                                    if (sHtml.substring(l,l+4).equals("<sup")){
                                                        verse1 += " ";
                                                        ignore_flag = true;
                                                        l += 4;
                                                    }
                                                    if (sHtml.substring(l,l+5).equals("<span")){
                                                        boolean redo3 = true;
                                                        while (redo3) {
                                                           if (sHtml.substring(l,l+1).equals(">")){
                                                               redo3 = false;
                                                           }
                                                           l += 1;
                                                        }
                                                    }
                                                    if (sHtml.substring(l,l+7).equals("</span>")){
                                                        l += 7;
                                                    }
                                                    if (sHtml.substring(l,l+7).equals("</span>")){
                                                        l += 7;
                                                    }
                                                    if (sHtml.substring(l,l+4).equals("</p>")){
                                                        //verse complete
                                                        break outerLoop;
                                                    }
                                                    if (sHtml.substring(l,l+4).equals("<div")){
                                                        //verse complete
                                                        break outerLoop;
                                                    }
                                                    if (sHtml.substring(l,l+5).equals("</div")){
                                                        //verse complete
                                                        break outerLoop;
                                                    }
                                                    if (ignore_flag == false){
                                                        verse1 += sHtml.substring(l,l+1);
                                                    }
                                                } // end of l loop
                                            }
                                            else{
                                            //verse = 1
                                            }
                                        } // end of k loop
                                    } // end of nasb
                                    /*else {
                                    //NKJV
                                        for (int k = j; k <= sHtml.length() -14; k ++){
                                            if (sHtml.substring(k,k+6).equals("</sup>")){
                                                k += 6;
                                                for (int l = k; l <= sHtml.length() - 14; l++) {
                                                    if (sHtml.substring(l,l+6).equals("</sup>")){
                                                        ignore_flag = false;
                                                        l += 6;
                                                    }
                                                    if (sHtml.substring(l,l+4).equals("<sup")){
                                                        verse1 += " ";
                                                        ignore_flag = true;
                                                        l += 4;
                                                    }
                                                    boolean redo1 = true;
                                                    while (redo1) {
                                                       if (sHtml.substring(l,l+3).equals("<i>")){
                                                           verse1 += " ";
                                                           l += 3;
                                                       }
                                                       else if(sHtml.substring(l, l + 4).equals("</i>"))
                                                       {
                                                           verse1 += " ";
                                                           l += 4;
                                                       }
                                                       else if(sHtml.substring(l, l + 6).equals("<br />"))
                                                       {
                                                           verse1 += " ";
                                                           l += 6;
                                                       }
                                                       else {
                                                           redo1 = false;
                                                       }
                                                    }
                                                    if (sHtml.substring(l,l+5).equals("<font")){
                                                        boolean redo2 = true;
                                                        while (redo2) {
                                                           if (sHtml.substring(l,l+1).equals(">")){
                                                               redo2 = false;
                                                           }
                                                           l += 1;
                                                        }
                                                    }
                                                    if (sHtml.substring(l,l+7).equals("</font>")){
                                                        l += 7;
                                                    }
                                                    if (sHtml.substring(l,l+5).equals("<p />")){
                                                        l += 5;
                                                    }
                                                    if (sHtml.substring(l,l+4).equals("</p>")){
                                                        //verse complete
                                                        break outerLoop;
                                                    }
                                                    if (ignore_flag == false){
                                                        verse1 += sHtml.substring(l,l+1);
                                                    }
                                                } // end of l loop
                                            }
                                        } // end of k loop
                                    } //end of nkjv

                                    //end of version check

                                }
                            } // end of j loop
                        }
                    } //end of i loop
                }
                else { //nkjv or kjv OT
                    outerLoopx:
                    for (int i = 0; i <= sHtml.length() -14; i++){
                        if (sHtml.substring(i,i+15).equals("heading passage")){
                            for (int j = i; j <= sHtml.length() -14; j++){
                                if (verse >= 1){
                                    //if (sHtml.substring(j,j+4).equals("><p>")){
                                    if (sHtml.substring(j,j+10).equals('\"' + "versenum" + '\"')){
                                        boolean redo4 = true;
                                        while (redo4) {
                                           if (sHtml.substring(j,j+6).equals("</sup>")){
                                               redo4 = false;
                                               j += 5;
                                           }
                                           j += 1;
                                        }
                                    //NKJV
                                        for (int k = j; k <= sHtml.length() -14; k ++){
                                            //if (sHtml.substring(k,k+6).equals("</sup>")){
                                                //k += 6;
                                                for (int l = k; l <= sHtml.length() - 14; l++) {
                                                    if (sHtml.substring(l,l+6).equals("</sup>")){
                                                        ignore_flag = false;
                                                        l += 6;
                                                    }
                                                    if (sHtml.substring(l,l+4).equals("<sup")){
                                                        verse1 += " ";
                                                        ignore_flag = true;
                                                        l += 4;
                                                    }
                                                    boolean redo1 = true;
                                                    while (redo1) {
                                                       if (sHtml.substring(l,l+3).equals("<i>")){
                                                           verse1 += " ";
                                                           l += 3;
                                                       }
                                                       else if(sHtml.substring(l, l + 4).equals("</i>"))
                                                       {
                                                           verse1 += " ";
                                                           l += 4;
                                                       }
                                                       else if(sHtml.substring(l, l + 6).equals("<br />"))
                                                       {
                                                           verse1 += " ";
                                                           l += 6;
                                                       }
                                                       else {
                                                           redo1 = false;
                                                       }
                                                    }
                                                    if (sHtml.substring(l,l+5).equals("<font")){
                                                        boolean redo2 = true;
                                                        while (redo2) {
                                                           if (sHtml.substring(l,l+1).equals(">")){
                                                               redo2 = false;
                                                           }
                                                           l += 1;
                                                        }
                                                    }
                                                    if (sHtml.substring(l,l+7).equals("</font>")){
                                                        l += 7;
                                                    }
                                                    if (sHtml.substring(l,l+5).equals("<p />")){
                                                        l += 5;
                                                    }
                                                    if (sHtml.substring(l,l+5).equals("<span")){
                                                        boolean redo3 = true;
                                                        while (redo3) {
                                                           if (sHtml.substring(l,l+1).equals(">")){
                                                               redo3 = false;
                                                           }
                                                           l += 1;
                                                        }
                                                    }
                                                    if (sHtml.substring(l,l+7).equals("</span>")){
                                                        l += 7;
                                                    }
                                                    if (sHtml.substring(l,l+7).equals("</span>")){
                                                        l += 7;
                                                    }
                                                    if (sHtml.substring(l,l+4).equals("<sup")){
                                                        boolean redo5 = true;
                                                        while (redo5) {
                                                            l += 1;
                                                            if (sHtml.substring(l+1,l+3).equals("<a")){
                                                                boolean redo6 = true;
                                                                while (redo6) {
                                                                    l+=3;
                                                                    if (sHtml.substring(l,l+2).equals("a>")){
                                                                        redo6 = false;
                                                                        l += 3;
                                                                    }
                                                                }
                                                            }
                                                            if (sHtml.substring(l,l+1).equals(">")){
                                                                redo5 = false;
                                                            }
                                                        }
                                                    }
                                                    if (sHtml.substring(l,l+4).equals("</p>")){
                                                        //verse complete
                                                        break outerLoopx;
                                                    }
                                                    if (ignore_flag == false){
                                                        verse1 += sHtml.substring(l,l+1);
                                                    }
                                                } // end of l loop
                                            //}
                                        } // end of k loop
                                     //end of nkjv

                                    //end of version check

                                    }
                                }
                             /*else{ //verse 1. not needed currently because of no chapternum in html source
                                    //if (sHtml.substring(j,j+4).equals("><p>")){
                                    if (sHtml.substring(j,j+12).equals('\"' + "chapternum" + '\"')){
                                        boolean redo4 = true;
                                        while (redo4) {
                                           if (sHtml.substring(j,j+7).equals("</span>")){
                                               redo4 = false;
                                               j += 6;
                                           }
                                           j += 1;
                                        }
                                    //NKJV
                                        for (int k = j; k <= sHtml.length() -14; k ++){
                                            //if (sHtml.substring(k,k+6).equals("</sup>")){
                                                //k += 6;
                                                for (int l = k; l <= sHtml.length() - 14; l++) {
                                                    if (sHtml.substring(l,l+6).equals("</sup>")){
                                                        ignore_flag = false;
                                                        l += 6;
                                                    }
                                                    if (sHtml.substring(l,l+4).equals("<sup")){
                                                        verse1 += " ";
                                                        ignore_flag = true;
                                                        l += 4;
                                                    }
                                                    boolean redo1 = true;
                                                    while (redo1) {
                                                       if (sHtml.substring(l,l+3).equals("<i>")){
                                                           verse1 += " ";
                                                           l += 3;
                                                       }
                                                       else if(sHtml.substring(l, l + 4).equals("</i>"))
                                                       {
                                                           verse1 += " ";
                                                           l += 4;
                                                       }
                                                       else if(sHtml.substring(l, l + 6).equals("<br />"))
                                                       {
                                                           verse1 += " ";
                                                           l += 6;
                                                       }
                                                       else {
                                                           redo1 = false;
                                                       }
                                                    }
                                                    if (sHtml.substring(l,l+5).equals("<font")){
                                                        boolean redo2 = true;
                                                        while (redo2) {
                                                           if (sHtml.substring(l,l+1).equals(">")){
                                                               redo2 = false;
                                                           }
                                                           l += 1;
                                                        }
                                                    }
                                                    if (sHtml.substring(l,l+7).equals("</font>")){
                                                        l += 7;
                                                    }
                                                    if (sHtml.substring(l,l+5).equals("<p />")){
                                                        l += 5;
                                                    }
                                                    if (sHtml.substring(l,l+5).equals("<span")){
                                                        boolean redo3 = true;
                                                        while (redo3) {
                                                           if (sHtml.substring(l,l+1).equals(">")){
                                                               redo3 = false;
                                                           }
                                                           l += 1;
                                                        }
                                                    }
                                                    if (sHtml.substring(l,l+7).equals("</span>")){
                                                        l += 7;
                                                    }
                                                    if (sHtml.substring(l,l+7).equals("</span>")){
                                                        l += 7;
                                                    }
                                                    if (sHtml.substring(l,l+4).equals("<sup")){
                                                        boolean redo5 = true;
                                                        while (redo5) {
                                                            l += 1;
                                                            if (sHtml.substring(l+1,l+3).equals("<a")){
                                                                boolean redo6 = true;
                                                                while (redo6) {
                                                                    l+=3;
                                                                    if (sHtml.substring(l,l+2).equals("a>")){
                                                                        redo6 = false;
                                                                        l += 3;
                                                                    }
                                                                }
                                                            }
                                                            if (sHtml.substring(l,l+1).equals(">")){
                                                                redo5 = false;
                                                            }
                                                        }
                                                    }
                                                    if (sHtml.substring(l,l+4).equals("</p>")){
                                                        //verse complete
                                                        break outerLoopx;
                                                    }
                                                    if (ignore_flag == false){
                                                        verse1 += sHtml.substring(l,l+1);
                                                    }
                                                } // end of l loop
                                            //}
                                        } // end of k loop
                                     //end of nkjv

                                    //end of version check

                                    }
                                }/*
                            }
                        }
                    } //end of i loop
                }*/
                //verse1 = verse1.replace("&nbsp;","");
                //verse1 = verse1.replace(" " + '\"' + " "," ");
                /*forLoop1:
                for (int i = 0; i <= verse1.length() - 14; i++){
                	if (verse1.substring(i,i+3).equals(" - ")){
                		verse1 = verse1.substring(i+3,verse1.length());
                		break forLoop1;
                	}
                }
                versetext = verse1;
            }
            catch (Exception ex){
                versetext = "Error parsing HTML string for verse.";
            }*/
        }
        return versetext;
    }

    static int[] updChapters(String book)
        {
            int[] Chap_length = new int[1];
            if (book.equals("Matthew")){
                int[] chap_length = { 0, 25, 23, 17, 25, 48, 34, 29, 34, 38, 42, 30, 50, 58, 36, 39, 28, 27, 35, 30, 34, 46, 46, 39, 51, 46, 75, 66, 20 };
                Chap_length = chap_length;
            }
            else if (book.equals("Mark")){
                int[] chap_length = { 0, 45, 28, 35, 41, 43, 56, 37, 38, 50, 52, 33, 44, 37, 72, 47, 20 };
                Chap_length = chap_length;
            }
            else if (book.equals("Luke")){
                int[] chap_length = { 0, 80, 52, 38, 44, 39, 49, 50, 56, 62, 42, 54, 59, 35, 35, 32, 31, 37, 43, 48, 47, 38, 71, 56, 53 };
                Chap_length = chap_length;
            }
            else if (book.equals("John")){
                int[] chap_length = {0, 51, 25, 36, 54, 47, 71, 53, 59, 41, 42, 57, 50, 38, 31, 27, 33, 26, 40, 42, 31, 25};
                Chap_length = chap_length;
            }
            else if (book.equals("Acts")){
                int[] chap_length = { 0, 26, 47, 26, 37, 42, 15, 60, 40, 43, 48, 30, 25, 52, 28, 41, 40, 34, 28, 41, 38, 40, 30, 35, 27, 27, 32, 44, 31 };
                Chap_length = chap_length;
            }
            else if (book.equals("Romans")){
                int[] chap_length = {0, 32, 29, 31, 25, 21, 23, 25, 39, 33, 21, 36, 21, 14, 23, 33, 27};
                Chap_length = chap_length;
            }
            else if (book.equals("1 Corinthians")){
                int[] chap_length = { 0, 31, 16, 23, 21, 13, 20, 40, 13, 27, 33, 34, 31, 13, 40, 58, 24 };
                Chap_length = chap_length;
            }
            else if (book.equals("2 Corinthians")){
                int[] chap_length = { 0, 24, 17, 18, 18, 21, 18, 16, 24, 15, 18, 33, 21, 14 };
                Chap_length = chap_length;
            }
            else if (book.equals("Galatians")){
                int[] chap_length = { 0, 24, 21, 29, 31, 26, 18 };
                Chap_length = chap_length;
            }
            else if (book.equals("Ephesians")){
                int[] chap_length = { 0, 23, 22, 21, 32, 33, 24 };
                Chap_length = chap_length;
            }
            else if (book.equals("Philippians")){
                int[] chap_length = {0, 30, 30, 21, 23};
                Chap_length = chap_length;
            }
            else if (book.equals("Colossians")){
                int[] chap_length = { 0, 29, 23, 25, 18 };
                Chap_length = chap_length;
            }
            else if (book.equals("1 Thessalonians")){
                int[] chap_length = { 0, 10, 20, 13, 18, 28 };
                Chap_length = chap_length;
            }
            else if (book.equals("2 Thessalonians")){
                int[] chap_length = { 0, 12, 17, 18 };
                Chap_length = chap_length;
            }
            else if (book.equals("1 Timothy")){
                int[] chap_length = { 0, 20, 15, 16, 16, 25, 21 };
                Chap_length = chap_length;
            }
            else if (book.equals("2 Timothy")){
                int[] chap_length = { 0, 18, 26, 17, 22 };
                Chap_length = chap_length;
            }
            else if (book.equals("Titus")){
                int[] chap_length = { 0, 16, 15, 15 };
                Chap_length = chap_length;
            }
            else if (book.equals("Philemon")){
                int[] chap_length = { 0, 25 };
                Chap_length = chap_length;
            }
            else if (book.equals("Hebrews")){
                int[] chap_length = { 0, 14, 18, 19, 16, 14, 20, 28, 13, 28, 39, 40, 29, 25 };
                Chap_length = chap_length;
            }
            else if (book.equals("James")){
                int[] chap_length = {0, 27, 26, 18, 17, 20};
                Chap_length = chap_length;
            }
            else if (book.equals("1 Peter")){
                int[] chap_length = { 0, 25, 25, 22, 19, 14 };
                Chap_length = chap_length;
            }
            else if (book.equals("2 Peter")){
                int[] chap_length = { 0, 21, 22, 18 };
                Chap_length = chap_length;
            }
            else if (book.equals("1 John")){
                int[] chap_length = { 0, 10, 29, 24, 21, 21 };
                Chap_length = chap_length;
            }
            else if (book.equals("2 John")){
                int[] chap_length = { 0, 13 };
                Chap_length = chap_length;
            }
            else if (book.equals("3 John")){
                int[] chap_length = { 0, 14 };
                Chap_length = chap_length;
            }
            else if (book.equals("Jude")){
                int[] chap_length = { 0, 25 };
                Chap_length = chap_length;
            }
            else if (book.equals("Revelation")){
                int[] chap_length = { 0, 20, 29, 22, 11, 14, 17, 17, 13, 21, 11, 19, 17, 18, 20, 8, 21, 18, 24, 21, 15, 27, 21 };
                Chap_length = chap_length;
            }
            else if (book.equals("Genesis")){
                int[] chap_length = { 0, 31, 25, 24, 26, 32, 22, 24, 22, 29, 32, 32, 20, 18, 24, 21, 16, 27, 33, 38, 18, 34, 24,
                20, 67, 34, 35, 46, 22, 35, 43, 55, 32, 20, 31, 29, 43, 36, 30, 23, 23, 57, 38, 34, 34, 28, 34, 31, 22, 33, 26 };
                Chap_length = chap_length;
            }
            else if (book.equals("Exodus")){
            	int[] chap_length = { 0, 22, 25, 22, 31, 23, 30, 25, 32, 35, 29, 10, 51, 22, 31, 27, 36, 16, 27, 25, 26,
            			36, 31, 33, 18, 40, 37, 21, 43, 46, 38, 18, 35, 23, 35, 35, 38, 29, 31, 43, 38 };
            	Chap_length = chap_length;
            }
            else if (book.equals("Leviticus")){
            	int[] chap_length = { 0, 17, 16, 17, 35, 19, 30, 38, 36, 24, 20, 47, 8, 59, 57, 33, 34, 16, 30, 37, 27,
            			24, 33, 44, 23, 55, 46, 34};
            	Chap_length = chap_length;
            }
            else if (book.equals("Numbers")){
            	int[] chap_length = { 0, 54, 34, 51, 49, 31, 27, 89, 26, 23, 36, 35, 16, 33, 45, 41, 50, 13, 32, 22, 29,
            			35, 41, 30, 25, 18, 65, 23, 31, 40, 16, 54, 42, 56, 29, 34, 13};
            	Chap_length = chap_length;
            }
            else if (book.equals("Deuteronomy")){
            	int[] chap_length = { 0, 46, 37, 29, 49, 33, 25, 26, 20, 29, 22, 32, 32, 18, 29, 23, 22, 20, 22, 21, 20,
            			23, 30, 25, 22, 19, 19, 26, 68, 29, 20, 30, 52, 29, 12};
            	Chap_length = chap_length;
            }
            else if (book.equals("Joshua")){
            	int[] chap_length = { 0, 18, 24, 17, 24, 15, 27, 26, 35, 27, 43, 23, 24, 33, 15, 63, 10, 18, 28, 51, 9,
            			45, 34, 16, 33};
            	Chap_length = chap_length;
            }
            else if (book.equals("Judges")){
            	int[] chap_length = { 0, 36, 23, 31, 24, 31, 40, 25, 35, 57, 18, 40, 15, 25, 20, 20, 31, 13, 31, 30, 48,
            			25};
            	Chap_length = chap_length;
            }
            else if (book.equals("Ruth")){
            	int[] chap_length = { 0, 22, 23, 18, 22};
            	Chap_length = chap_length;
            }
            else if (book.equals("1 Samuel")){
            	int[] chap_length = { 0, 28, 36, 21, 22, 12, 21, 17, 22, 27, 27, 15, 25, 23, 52, 35, 23, 58, 30, 24, 42,
            			15, 23, 29, 22, 44, 25, 12, 25, 11, 31, 13};
            	Chap_length = chap_length;
            }
            else if (book.equals("2 Samuel")){
            	int[] chap_length = { 0, 27, 32, 39, 12, 25, 23, 29, 18, 13, 19, 27, 31, 39, 33, 37, 23, 29, 33, 43, 26,
            			22, 51, 39, 25};
            	Chap_length = chap_length;
            }
            else if (book.equals("1 Kings")){
            	int[] chap_length = { 0, 53, 46, 28, 34, 18, 38, 51, 66, 28, 29, 43, 33, 34, 31, 34, 34, 24, 46, 21, 43,
            			29, 53};
            	Chap_length = chap_length;
            }
            else if (book.equals("2 Kings")){
            	int[] chap_length = { 0, 18, 25, 27, 44, 27, 33, 20, 29, 37, 36, 21, 21, 25, 29, 38, 20, 41, 37, 37, 21,
            			26, 20, 37, 20, 30};
            	Chap_length = chap_length;
            }
            else if (book.equals("1 Chronicles")){
            	int[] chap_length = { 0, 54, 55, 24, 43, 26, 81, 40, 40, 44, 14, 47, 40, 14, 17, 29, 43, 27, 17, 19, 8,
            			30, 19, 32, 31, 31, 32, 34, 21, 30};
            	Chap_length = chap_length;
            }
            else if (book.equals("2 Chronicles")){
            	int[] chap_length = { 0, 17, 18, 17, 22, 14, 42, 22, 18, 31, 19, 23, 16, 22, 15, 19, 14, 19, 34, 11, 37,
            			20, 12, 21, 27, 28, 23, 9, 27, 36, 27, 21, 33, 25, 33, 27, 23};
            	Chap_length = chap_length;
            }
            else if (book.equals("Ezra")){
            	int[] chap_length = { 0, 11, 70, 13, 24, 17, 22, 28, 36, 15, 44};
            	Chap_length = chap_length;
            }
            else if (book.equals("Nehemiah")){
            	int[] chap_length = { 0, 11, 20, 32, 23, 19, 19, 73, 18, 38, 39, 36, 47, 31};
            	Chap_length = chap_length;
            }
            else if (book.equals("Esther")){
            	int[] chap_length = { 0, 22, 23, 15, 17, 14, 14, 10, 17, 32, 3};
            	Chap_length = chap_length;
            }
            else if (book.equals("Job")){
            	int[] chap_length = { 0, 22, 13, 26, 21, 27, 30, 21, 22, 35, 22, 20, 25, 28, 22, 35, 22, 16, 21, 29, 29,
            			34, 30, 17, 25, 6, 14, 23, 28, 25, 31, 40, 22, 33, 37, 16, 33, 24, 41, 30, 24,
            			34, 17};
            	Chap_length = chap_length;
            }
            else if (book.equals("Psalm")){
            	int[] chap_length = { 0, 6, 12, 8, 8, 12, 10, 17, 9, 20, 18, 7, 8, 6, 7, 5, 11, 15, 50, 14, 9,
            			13, 31, 6, 10, 22, 12, 14, 9, 11, 12, 24, 11, 22, 22, 28, 12, 40, 22, 13, 17,
            			13, 11, 5, 26, 17, 11, 9, 14, 20, 23, 19, 9, 6, 7, 23, 13, 11, 11, 17, 12,
            			8, 12, 11, 10, 13, 20, 7, 35, 36, 5, 24, 20, 28, 23, 10, 12, 20, 72, 13, 19,
            			16, 8, 18, 12, 13, 17, 7, 18, 52, 17, 16, 15, 5, 23, 11, 13, 12, 9, 9, 5,
            			8, 28, 22, 35, 45, 48, 43, 13, 31, 7, 10, 10, 9, 8, 18, 19, 2, 29, 176, 7,
            			8, 9, 4, 8, 5, 6, 5, 6, 8, 8, 3, 18, 3, 3, 21, 26, 9, 8, 24, 13,
            			10, 7, 12, 15, 21, 10, 20, 14, 9, 6};
            	Chap_length = chap_length;
            }
            else if (book.equals("Proverbs")){
            	int[] chap_length = { 0, 33, 22, 35, 27, 23, 35, 27, 36, 18, 32, 31, 28, 25, 35, 33, 33, 28, 24, 29, 30, 
            			31, 29, 35, 34, 28, 28, 27, 28, 27, 33, 31};
            	Chap_length = chap_length;
            }
            else if (book.equals("Ecclesiastes")){
            	int[] chap_length = { 0, 18, 26, 22, 16, 20, 12, 29, 17, 18, 20, 10, 14};
            	Chap_length = chap_length;
            }
            else if (book.equals("Song of Solomon")){
            	int[] chap_length = { 0, 17, 17, 11, 16, 16, 13, 13, 14};
            	Chap_length = chap_length;
            }
            else if (book.equals("Isaiah")){
            	int[] chap_length = { 0, 31, 22, 26, 6, 30, 13, 25, 22, 21, 34, 16, 6, 22, 32, 9, 14, 14, 7, 25, 6,
            			17, 25, 18, 23, 12, 21, 13, 29, 24, 33, 9, 20, 24, 17, 10, 22, 38, 22, 8, 31,
            			29, 25, 28, 28, 25, 13, 15, 22, 26, 11, 23, 15, 12, 17, 13, 12, 21, 14, 21, 22,
            			11, 12, 19, 12, 25, 24};
            	Chap_length = chap_length;
            }
            else if (book.equals("Jeremiah")){
            	int[] chap_length = { 0, 19, 37, 25, 31, 31, 30, 34, 22, 26, 25, 23, 17, 27, 22, 21, 21, 27, 23, 15, 18,
            			14, 30, 40, 10, 38, 24, 22, 17, 32, 24, 40, 44, 26, 22, 19, 32, 21, 28, 18, 16,
            			18, 22, 13, 30, 5, 28, 7, 47, 39, 46, 64, 34};
            	Chap_length = chap_length;
            }
            else if (book.equals("Lamentations")){
            	int[] chap_length = { 0, 22, 22, 66, 22, 22};
            	Chap_length = chap_length;
            }
            else if (book.equals("Ezekiel")){
            	int[] chap_length = { 0, 28, 10, 27, 17, 17, 14, 27, 18, 11, 22, 25, 28, 23, 23, 8, 63, 24, 32, 14, 49,
            			32, 31, 49, 27, 17, 21, 36, 26, 21, 26, 18, 32, 33, 31, 15, 38, 28, 23, 29, 49,
            			26, 20, 27, 31, 25, 24, 23, 35};
            	Chap_length = chap_length;
            }
            else if (book.equals("Daniel")){
            	int[] chap_length = { 0, 21, 49, 30, 37, 31, 28, 28, 27, 27, 21, 45, 13};
            	Chap_length = chap_length;
            }
            else if (book.equals("Hosea")){
            	int[] chap_length = { 0, 11, 23, 5, 19, 15, 11, 16, 14, 17, 15, 12, 14, 16, 9};
            	Chap_length = chap_length;
            }
            else if (book.equals("Joel")){
            	int[] chap_length = { 0, 20, 32, 21};
            	Chap_length = chap_length;
            }
            else if (book.equals("Amos")){
            	int[] chap_length = { 0, 15, 16, 15, 13, 27, 14, 17, 14, 15};
            	Chap_length = chap_length;
            }
            else if (book.equals("Obadiah")){
            	int[] chap_length = { 0, 21};
            	Chap_length = chap_length;
            }
            else if (book.equals("Jonah")){
            	int[] chap_length = { 0, 17, 10, 10, 11};
            	Chap_length = chap_length;
            }
            else if (book.equals("Micah")){
            	int[] chap_length = { 0, 16, 13, 12, 13, 15, 16, 20};
            	Chap_length = chap_length;
            }
            else if (book.equals("Nahum")){
            	int[] chap_length = { 0, 15, 13, 19};
            	Chap_length = chap_length;
            }
            else if (book.equals("Habakkuk")){
            	int[] chap_length = { 0, 17, 20, 19};
            	Chap_length = chap_length;
            }
            else if (book.equals("Zephaniah")){
            	int[] chap_length = { 0, 18, 15, 20};
            	Chap_length = chap_length;
            }
            else if (book.equals("Haggai")){
            	int[] chap_length = { 0, 15, 23};
            	Chap_length = chap_length;
            }
            else if (book.equals("Zechariah")){
            	int[] chap_length = { 0, 21, 13, 10, 14, 11, 15, 14, 23, 17, 12, 17, 14, 9, 21};
            	Chap_length = chap_length;
            }
            else if (book.equals("Malachi")){
            	int[] chap_length = { 0, 14, 17, 18, 6};
            	Chap_length = chap_length;
            }

	return Chap_length;
    }

    public static int SumArray(int[] chaplength){
        int result = 0;
        for (int i = 0; i <= chaplength.length-1; i++){
            result += chaplength[i];
        }
        return result;
    }
    

    public static int RandomNumber(int MaxNumber){
        Random generator = new Random();
        int randomIndex = generator.nextInt(MaxNumber) + 1;
        return randomIndex;

    }

}
