package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLVector;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLPageBlockRelatedArticles extends TLAbsPageBlock {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected TLAbsRichText title;

    protected TLVector<TLPageRelatedArticle> articles;

    private final String _constructor = "pageBlockRelatedArticles#0";

    public TLPageBlockRelatedArticles() {
    }

    public TLPageBlockRelatedArticles(TLAbsRichText title, TLVector<TLPageRelatedArticle> articles) {
        this.title = title;
        this.articles = articles;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(title, stream);
        writeTLVector(articles, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        title = readTLObject(stream, context, TLAbsRichText.class, -1);
        articles = readTLVector(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += title.computeSerializedSize();
        size += articles.computeSerializedSize();
        return size;
    }

    @Override
    public String toString() {
        return _constructor;
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    public TLAbsRichText getTitle() {
        return title;
    }

    public void setTitle(TLAbsRichText title) {
        this.title = title;
    }

    public TLVector<TLPageRelatedArticle> getArticles() {
        return articles;
    }

    public void setArticles(TLVector<TLPageRelatedArticle> articles) {
        this.articles = articles;
    }
}
