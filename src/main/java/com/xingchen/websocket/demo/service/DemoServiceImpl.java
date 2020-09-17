package com.xingchen.websocket.demo.service;

import com.xingchen.websocket.demo.constant.NumberWord;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class DemoServiceImpl implements DemoService {

    @Override
    public String getLettersByDigits(Integer[] digits) {
        if (digits.length > 0) {
            if (digits.length == 1) {
                return StringUtils.join(NumberWord.getByIndex(digits[0]), " ");
            } else {
                List<String[]> list = new ArrayList<>();
                for (Integer integer : digits) {
                    list.add(NumberWord.getByIndex(integer));
                }
                List<String> result = new ArrayList<>();
                getStr(list, 0, list.get(0), result);
                return StringUtils.join(result, " ");
            }

        }
        return "输入不能为空";
    }

    private void getStr(List<String[]> list, int length, String[] strings, List<String> result) {
        if (strings.length > 0) {
            if (result.size() > 0) {
                for (int i = 0; i < result.size(); i++) {
                    StringBuilder builder = new StringBuilder();
                    for (String s : strings) {
                        String[] ss = result.get(i).split(" ");
                        for (int h = 0; h < ss.length; h++) {
                            ss[h] = ss[h] + s;
                        }
                        builder.append(StringUtils.join(ss, " ")).append(" ");
                    }
                    result.set(i, builder.toString());
                }
            } else {
                Collections.addAll(result, strings);
            }
            length++;
            if (length < list.size()) {
                getStr(list, length, list.get(length), result);
            }

        } else {
            length++;
            if (length < list.size()) {
                getStr(list, length, list.get(length), result);
            }

        }
    }

}
