package com.cesar.fileuploadtest.util;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/**
 * Created by Cesar on 2016/11/29.
 */
public class Utils {

    private static HanyuPinyinOutputFormat pinyinOutputFormat =
            new HanyuPinyinOutputFormat();

    public static String transHanziToPinyin(String Hanzi) {

        pinyinOutputFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        pinyinOutputFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        pinyinOutputFormat.setVCharType(HanyuPinyinVCharType.WITH_V);
        try {
            String re = PinyinHelper.toHanYuPinyinString(Hanzi, pinyinOutputFormat, "", true);
            return re;
        } catch (BadHanyuPinyinOutputFormatCombination badHanyuPinyinOutputFormatCombination) {
            badHanyuPinyinOutputFormatCombination.printStackTrace();
        }
        return null;
    }
}
