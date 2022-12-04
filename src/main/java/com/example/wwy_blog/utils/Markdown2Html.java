package com.example.wwy_blog.utils;

import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.data.MutableDataSet;
import org.springframework.stereotype.Component;

@Component
public class Markdown2Html {

    /**
     * 将md格式文档转化为html格式
     *
     * @param md :md格式的字符串
     * @return html :html格式的字符串
     */
    public static String convert(String md) {
        MutableDataSet options = new MutableDataSet();

        Parser parser = Parser.builder(options).build();
        HtmlRenderer renderer = HtmlRenderer.builder(options).build();

        Node document = parser.parse(md);
        String html = renderer.render(document);
        return html;
    }
}
