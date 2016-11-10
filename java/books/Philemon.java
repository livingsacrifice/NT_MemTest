/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package books;

/**
 *
 * @author srichard
 */
public class Philemon {
public static String[][] chap(String version)
        {
            String[][] chap = new String[2][ 26];// 1 + chapters; 1 + longest verse
            if (version.equals("KJV")){
                    chap[1][1] = "Paul, a prisoner of Jesus Christ, and Timothy our brother, unto Philemon our dearly beloved, and fellowlabourer,";
                    chap[1][2] = "And to our beloved Apphia, and Archippus our fellowsoldier, and to the church in thy house:";
                    chap[1][3] = "Grace to you, and peace, from God our Father and the Lord Jesus Christ.";
                    chap[1][4] = "I thank my God, making mention of thee always in my prayers,";
                    chap[1][5] = "Hearing of thy love and faith, which thou hast toward the Lord Jesus, and toward all saints;";
                    chap[1][6] = "That the communication of thy faith may become effectual by the acknowledging of every good thing which is in you in Christ Jesus.";
                    chap[1][7] = "For we have great joy and consolation in thy love, because the bowels of the saints are refreshed by thee, brother.";
                    chap[1][8] = "Wherefore, though I might be much bold in Christ to enjoin thee that which is convenient,";
                    chap[1][9] = "Yet for love's sake I rather beseech thee, being such an one as Paul the aged, and now also a prisoner of Jesus Christ.";
                    chap[1][ 10] = "I beseech thee for my son Onesimus, whom I have begotten in my bonds:";
                    chap[1][ 11] = "Which in time past was to thee unprofitable, but now profitable to thee and to me:";
                    chap[1][ 12] = "Whom I have sent again: thou therefore receive him, that is, mine own bowels:";
                    chap[1][ 13] = "Whom I would have retained with me, that in thy stead he might have ministered unto me in the bonds of the gospel:";
                    chap[1][ 14] = "But without thy mind would I do nothing; that thy benefit should not be as it were of necessity, but willingly.";
                    chap[1][ 15] = "For perhaps he therefore departed for a season, that thou shouldest receive him for ever;";
                    chap[1][ 16] = "Not now as a servant, but above a servant, a brother beloved, specially to me, but how much more unto thee, both in the flesh, and in the Lord?";
                    chap[1][ 17] = "If thou count me therefore a partner, receive him as myself.";
                    chap[1][ 18] = "If he hath wronged thee, or oweth thee ought, put that on mine account;";
                    chap[1][ 19] = "I Paul have written it with mine own hand, I will repay it: albeit I do not say to thee how thou owest unto me even thine own self besides.";
                    chap[1][ 20] = "Yea, brother, let me have joy of thee in the Lord: refresh my bowels in the Lord.";
                    chap[1][ 21] = "Having confidence in thy obedience I wrote unto thee, knowing that thou wilt also do more than I say.";
                    chap[1][ 22] = "But withal prepare me also a lodging: for I trust that through your prayers I shall be given unto you.";
                    chap[1][ 23] = "There salute thee Epaphras, my fellowprisoner in Christ Jesus;";
                    chap[1][ 24] = "Marcus, Aristarchus, Demas, Lucas, my fellowlabourers.";
                    chap[1][ 25] = "The grace of our Lord Jesus Christ be with your spirit. Amen.";

            }
            return chap;
        }

}