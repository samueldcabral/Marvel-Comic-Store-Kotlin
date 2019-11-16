
package br.edu.ifpb.phoebus_marvel_store.retrofit_model;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result{

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("digitalId")
    @Expose
    private String digitalId;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("issueNumber")
    @Expose
    private String issueNumber;
    @SerializedName("variantDescription")
    @Expose
    private String variantDescription;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("modified")
    @Expose
    private String modified;
    @SerializedName("isbn")
    @Expose
    private String isbn;
    @SerializedName("upc")
    @Expose
    private String upc;
    @SerializedName("diamondCode")
    @Expose
    private String diamondCode;
    @SerializedName("ean")
    @Expose
    private String ean;
    @SerializedName("issn")
    @Expose
    private String issn;
    @SerializedName("format")
    @Expose
    private String format;
    @SerializedName("pageCount")
    @Expose
    private String pageCount;
    @SerializedName("textObjects")
    @Expose
    private List<br.edu.ifpb.phoebus_marvel_store.retrofit_model.TextObject> textObjects = null;
    @SerializedName("resourceURI")
    @Expose
    private String resourceURI;
    @SerializedName("urls")
    @Expose
    private List<br.edu.ifpb.phoebus_marvel_store.retrofit_model.Url> urls = null;
    @SerializedName("series")
    @Expose
    private br.edu.ifpb.phoebus_marvel_store.retrofit_model.Series series;
    @SerializedName("variants")
    @Expose
    private List<br.edu.ifpb.phoebus_marvel_store.retrofit_model.Variant> variants = null;
    @SerializedName("collections")
    @Expose
    private List<br.edu.ifpb.phoebus_marvel_store.retrofit_model.Collection> collections = null;
    @SerializedName("collectedIssues")
    @Expose
    private List<br.edu.ifpb.phoebus_marvel_store.retrofit_model.CollectedIssue> collectedIssues = null;
    @SerializedName("dates")
    @Expose
    private List<br.edu.ifpb.phoebus_marvel_store.retrofit_model.Date> dates = null;
    @SerializedName("prices")
    @Expose
    private List<br.edu.ifpb.phoebus_marvel_store.retrofit_model.Price> prices = null;
    @SerializedName("thumbnail")
    @Expose
    private br.edu.ifpb.phoebus_marvel_store.retrofit_model.Thumbnail thumbnail;
    @SerializedName("images")
    @Expose
    private List<br.edu.ifpb.phoebus_marvel_store.retrofit_model.Image> images = null;
    @SerializedName("creators")
    @Expose
    private br.edu.ifpb.phoebus_marvel_store.retrofit_model.Creators creators;
    @SerializedName("characters")
    @Expose
    private br.edu.ifpb.phoebus_marvel_store.retrofit_model.Characters characters;
    @SerializedName("stories")
    @Expose
    private br.edu.ifpb.phoebus_marvel_store.retrofit_model.Stories stories;
    @SerializedName("events")
    @Expose
    private br.edu.ifpb.phoebus_marvel_store.retrofit_model.Events events;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDigitalId() {
        return digitalId;
    }

    public void setDigitalId(String digitalId) {
        this.digitalId = digitalId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(String issueNumber) {
        this.issueNumber = issueNumber;
    }

    public String getVariantDescription() {
        return variantDescription;
    }

    public void setVariantDescription(String variantDescription) {
        this.variantDescription = variantDescription;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public String getDiamondCode() {
        return diamondCode;
    }

    public void setDiamondCode(String diamondCode) {
        this.diamondCode = diamondCode;
    }

    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }

    public String getIssn() {
        return issn;
    }

    public void setIssn(String issn) {
        this.issn = issn;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getPageCount() {
        return pageCount;
    }

    public void setPageCount(String pageCount) {
        this.pageCount = pageCount;
    }

    public List<br.edu.ifpb.phoebus_marvel_store.retrofit_model.TextObject> getTextObjects() {
        return textObjects;
    }

    public void setTextObjects(List<br.edu.ifpb.phoebus_marvel_store.retrofit_model.TextObject> textObjects) {
        this.textObjects = textObjects;
    }

    public String getResourceURI() {
        return resourceURI;
    }

    public void setResourceURI(String resourceURI) {
        this.resourceURI = resourceURI;
    }

    public List<br.edu.ifpb.phoebus_marvel_store.retrofit_model.Url> getUrls() {
        return urls;
    }

    public void setUrls(List<br.edu.ifpb.phoebus_marvel_store.retrofit_model.Url> urls) {
        this.urls = urls;
    }

    public br.edu.ifpb.phoebus_marvel_store.retrofit_model.Series getSeries() {
        return series;
    }

    public void setSeries(br.edu.ifpb.phoebus_marvel_store.retrofit_model.Series series) {
        this.series = series;
    }

    public List<br.edu.ifpb.phoebus_marvel_store.retrofit_model.Variant> getVariants() {
        return variants;
    }

    public void setVariants(List<br.edu.ifpb.phoebus_marvel_store.retrofit_model.Variant> variants) {
        this.variants = variants;
    }

    public List<br.edu.ifpb.phoebus_marvel_store.retrofit_model.Collection> getCollections() {
        return collections;
    }

    public void setCollections(List<br.edu.ifpb.phoebus_marvel_store.retrofit_model.Collection> collections) {
        this.collections = collections;
    }

    public List<br.edu.ifpb.phoebus_marvel_store.retrofit_model.CollectedIssue> getCollectedIssues() {
        return collectedIssues;
    }

    public void setCollectedIssues(List<br.edu.ifpb.phoebus_marvel_store.retrofit_model.CollectedIssue> collectedIssues) {
        this.collectedIssues = collectedIssues;
    }

    public List<br.edu.ifpb.phoebus_marvel_store.retrofit_model.Date> getDates() {
        return dates;
    }

    public void setDates(List<br.edu.ifpb.phoebus_marvel_store.retrofit_model.Date> dates) {
        this.dates = dates;
    }

    public List<br.edu.ifpb.phoebus_marvel_store.retrofit_model.Price> getPrices() {
        return prices;
    }

    public void setPrices(List<br.edu.ifpb.phoebus_marvel_store.retrofit_model.Price> prices) {
        this.prices = prices;
    }

    public br.edu.ifpb.phoebus_marvel_store.retrofit_model.Thumbnail getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(br.edu.ifpb.phoebus_marvel_store.retrofit_model.Thumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }

    public List<br.edu.ifpb.phoebus_marvel_store.retrofit_model.Image> getImages() {
        return images;
    }

    public void setImages(List<br.edu.ifpb.phoebus_marvel_store.retrofit_model.Image> images) {
        this.images = images;
    }

    public br.edu.ifpb.phoebus_marvel_store.retrofit_model.Creators getCreators() {
        return creators;
    }

    public void setCreators(br.edu.ifpb.phoebus_marvel_store.retrofit_model.Creators creators) {
        this.creators = creators;
    }

    public br.edu.ifpb.phoebus_marvel_store.retrofit_model.Characters getCharacters() {
        return characters;
    }

    public void setCharacters(br.edu.ifpb.phoebus_marvel_store.retrofit_model.Characters characters) {
        this.characters = characters;
    }

    public br.edu.ifpb.phoebus_marvel_store.retrofit_model.Stories getStories() {
        return stories;
    }

    public void setStories(br.edu.ifpb.phoebus_marvel_store.retrofit_model.Stories stories) {
        this.stories = stories;
    }

    public br.edu.ifpb.phoebus_marvel_store.retrofit_model.Events getEvents() {
        return events;
    }

    public void setEvents(br.edu.ifpb.phoebus_marvel_store.retrofit_model.Events events) {
        this.events = events;
    }

}
