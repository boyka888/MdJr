/**
 * chenxitech.cn Inc. Copyright (c) 2017-2019 All Rights Reserved.
 */
package com.md.client.trans.querier;

import com.md.client.trans.Lang;
import com.md.client.trans.http.AbstractHttpAttribute;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tangyue
 * @version $Id: Querier.java, v 0.1 2019-12-04 9:34 tangyue Exp $$
 */
public final class Querier<T extends AbstractHttpAttribute> {
    private Lang from;
    private Lang to;
    private String text;
    private List<T> collection;

    public Querier() {
        collection = new ArrayList<T>();
    }

    public List<String> execute() {
        List<String> result = new ArrayList<>();

        for (T element : collection) {
            if (element.getClass().getName().contains("Translator")) {
                result.add(element.run(from, to, text));
            } else if (element.getClass().getName().contains("TTS")) {
                result.add(element.run(from, text));
            }
        }
        return result;
    }

    public void setParams(Lang from, Lang to, String text) {
        this.from = from;
        this.to = to;
        this.text = text;
    }

    public void setParams(Lang source, String text) {
        this.from = source;
        this.text = text;
    }

    public void attach(T element){
        collection.add(element);
    }

    public void detach(T element) {
        collection.remove(element);
    }
}
