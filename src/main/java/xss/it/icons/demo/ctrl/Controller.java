package xss.it.icons.demo.ctrl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import xss.it.icons.GlyphIcon;
import xss.it.icons.awesome.Awesome;
import xss.it.icons.awesome.AwesomeIcon;
import xss.it.icons.emoji.Emoji;
import xss.it.icons.emoji.EmojiIcon;
import xss.it.icons.ic525.Ic525;
import xss.it.icons.ic525.Ic525Icon;
import xss.it.icons.material.Material;
import xss.it.icons.material.MaterialIcon;
import xss.it.icons.materialdesign.MaterialDesign;
import xss.it.icons.materialdesign.MaterialDesignIcon;
import xss.it.icons.octicons.Oct;
import xss.it.icons.octicons.OctIcon;
import xss.it.icons.weather.Weather;
import xss.it.icons.weather.WeatherIcon;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author XDSSWAR
 * Created on 03/27/2023
 */
public class Controller implements Initializable {
    @FXML
    private FlowPane designFlowPane;

    @FXML
    private ScrollPane designScrollPane;

    @FXML
    private TextField designSearch;

    @FXML
    private FlowPane emojiFlowPane;

    @FXML
    private ScrollPane emojiScrollPane;

    @FXML
    private TextField emojiSearch;

    @FXML
    private FlowPane fontAwesomeFlowPane;

    @FXML
    private ScrollPane fontAwesomeScrollPane;

    @FXML
    private TextField fontAwesomeSearch;

    @FXML
    private FlowPane ic525FlowPane;

    @FXML
    private ScrollPane ic525ScrollPane;

    @FXML
    private TextField ic525Search;

    @FXML
    private FlowPane materialFlowPane;

    @FXML
    private ScrollPane materialScrollPane;

    @FXML
    private TextField materialSearch;

    @FXML
    private FlowPane octiconFlowPane;

    @FXML
    private ScrollPane octiconScrollPane;

    @FXML
    private TextField octiconSearch;

    @FXML
    private FlowPane weatherFlowPane;

    @FXML
    private ScrollPane weatherScrollPane;

    @FXML
    private TextField weatherSearch;

    @FXML
    private TabPane tabPane;

    private final Stage stage;
    private static final Clipboard clipBoard=Clipboard.getSystemClipboard();
    private final ObservableList<Button> awesome= FXCollections.observableArrayList();
    private final ObservableList<Button> emoji= FXCollections.observableArrayList();
    private final ObservableList<Button> ic525= FXCollections.observableArrayList();
    private final ObservableList<Button> material= FXCollections.observableArrayList();
    private final ObservableList<Button> design= FXCollections.observableArrayList();
    private final ObservableList<Button> octIcons= FXCollections.observableArrayList();
    private final ObservableList<Button> weather= FXCollections.observableArrayList();

    /**
     * Constructor
     * @param stage Stage
     */
    public Controller(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initialize();
    }

    /**
     * Init all
     */
    private void initialize(){

        /*
         * Font Awesome
         */
        initFontAwesome();

        /*
         * Emoji
         */
        initEmoji();

        /*
         * Ic 525
         */
        initIc525();

        /*
         * Init Material
         */
        initMaterial();

        /*
         * Material Design
         */
        initMaterialDesign();

        /*
         * OctIcons
         */
        initOctIcons();

        /*
         * Weather Icons
         */
        initWeatherIcons();

        /*
         * Clean Search fields
         */
        tabPane.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            fontAwesomeSearch.clear();
            emojiSearch.clear();
            ic525Search.clear();
            materialSearch.clear();
            designSearch.clear();
            octiconSearch.clear();
            weatherSearch.clear();
        });
    }

    /**
     * Setup flowPane
     * @param pane FlowPane
     */
    private void setupFlowPane(FlowPane pane){
        pane.setVgap(20);
        pane.setHgap(20);
    }

    /**
     * Setup Icon
     * @param icon Icon
     */
    private void setupIcon(GlyphIcon<?> icon){
        icon.setGlyphSize(40);
    }

    /**
     * Init Font Awesome
     */
    private void initFontAwesome(){
        fontAwesomeScrollPane.setFitToWidth(true);
        setupFlowPane(fontAwesomeFlowPane);
        for (Awesome value : Awesome.values()) {
            AwesomeIcon icon=new AwesomeIcon();
            icon.getStyleClass().add("icon");
            icon.setGlyphName(value.name());
            setupIcon(icon);
            Button button=new Button(value.name());
            button.setContentDisplay(ContentDisplay.TOP);
            button.getStyleClass().add("icon-button");
            button.setGraphic(icon);
            button.setOnAction(event -> {
                final ClipboardContent content = new ClipboardContent();
                content.putString(value.name());
                clipBoard.setContent(content);
            });
            awesome.add(button);
        }
        fontAwesomeFlowPane.getChildren().addAll(awesome);
        addFilter(awesome,fontAwesomeSearch,fontAwesomeFlowPane);
    }

    /**
     * Init Emoji
     */
    private void initEmoji(){
        emojiScrollPane.setFitToWidth(true);
        setupFlowPane(emojiFlowPane);
        for (Emoji value : Emoji.values()) {
            EmojiIcon icon=new EmojiIcon();
            icon.getStyleClass().add("icon");
            icon.setGlyphName(value.name());
            setupIcon(icon);
            Button button=new Button(value.name());
            button.setContentDisplay(ContentDisplay.TOP);
            button.getStyleClass().add("icon-button");
            button.setGraphic(icon);
            button.setOnAction(event -> {
                final ClipboardContent content = new ClipboardContent();
                content.putString(value.name());
                clipBoard.setContent(content);
            });
            emoji.add(button);
        }
        emojiFlowPane.getChildren().addAll(emoji);
        addFilter(emoji,emojiSearch,emojiFlowPane);
    }

    /**
     * Init IC525
     */
    private void initIc525(){
        ic525ScrollPane.setFitToWidth(true);
        setupFlowPane(ic525FlowPane);
        for (Ic525 value : Ic525.values()) {
            Ic525Icon icon=new Ic525Icon();
            icon.getStyleClass().add("icon");
            icon.setGlyphName(value.name());
            setupIcon(icon);
            Button button=new Button(value.name());
            button.setContentDisplay(ContentDisplay.TOP);
            button.getStyleClass().add("icon-button");
            button.setGraphic(icon);
            button.setOnAction(event -> {
                final ClipboardContent content = new ClipboardContent();
                content.putString(value.name());
                clipBoard.setContent(content);
            });
            ic525.add(button);
        }
        ic525FlowPane.getChildren().addAll(ic525);
        addFilter(ic525,ic525Search,ic525FlowPane);
    }

    /**
     * Init Material
     */
    private void initMaterial(){
        materialScrollPane.setFitToWidth(true);
        setupFlowPane(materialFlowPane);
        for (Material value : Material.values()) {
            MaterialIcon icon=new MaterialIcon();
            icon.getStyleClass().add("icon");
            icon.setGlyphName(value.name());
            setupIcon(icon);
            Button button=new Button(value.name());
            button.setContentDisplay(ContentDisplay.TOP);
            button.getStyleClass().add("icon-button");
            button.setGraphic(icon);
            button.setOnAction(event -> {
                final ClipboardContent content = new ClipboardContent();
                content.putString(value.name());
                clipBoard.setContent(content);
            });
            material.add(button);
        }
        materialFlowPane.getChildren().addAll(material);
        addFilter(material,materialSearch,materialFlowPane);
    }

    /**
     * Init MaterialDesign
     */
    private void initMaterialDesign(){
        designScrollPane.setFitToWidth(true);
        setupFlowPane(designFlowPane);
        for (MaterialDesign value : MaterialDesign.values()) {
            MaterialDesignIcon icon=new MaterialDesignIcon();
            icon.getStyleClass().add("icon");
            icon.setGlyphName(value.name());
            setupIcon(icon);
            Button button=new Button(value.name());
            button.setContentDisplay(ContentDisplay.TOP);
            button.getStyleClass().add("icon-button");
            button.setGraphic(icon);
            button.setOnAction(event -> {
                final ClipboardContent content = new ClipboardContent();
                content.putString(value.name());
                clipBoard.setContent(content);
            });
            design.add(button);
        }
        designFlowPane.getChildren().addAll(design);
        addFilter(design,designSearch,designFlowPane);
    }

    /**
     * Init OctIcons
     */
    private void initOctIcons(){
        octiconScrollPane.setFitToWidth(true);
        setupFlowPane(octiconFlowPane);
        for (Oct value : Oct.values()) {
            OctIcon icon=new OctIcon();
            icon.getStyleClass().add("icon");
            icon.setGlyphName(value.name());
            setupIcon(icon);
            Button button=new Button(value.name());
            button.setContentDisplay(ContentDisplay.TOP);
            button.getStyleClass().add("icon-button");
            button.setGraphic(icon);
            button.setOnAction(event -> {
                final ClipboardContent content = new ClipboardContent();
                content.putString(value.name());
                clipBoard.setContent(content);
            });
            octIcons.add(button);
        }
        octiconFlowPane.getChildren().addAll(octIcons);
        addFilter(octIcons,octiconSearch,octiconFlowPane);
    }

    /**
     * Init OctIcons
     */
    private void initWeatherIcons(){
        weatherScrollPane.setFitToWidth(true);
        setupFlowPane(weatherFlowPane);
        for (Weather value : Weather.values()) {
            WeatherIcon icon=new WeatherIcon();
            icon.getStyleClass().add("icon");
            icon.setGlyphName(value.name());
            setupIcon(icon);
            Button button=new Button(value.name());
            button.setContentDisplay(ContentDisplay.TOP);
            button.getStyleClass().add("icon-button");
            button.setGraphic(icon);
            button.setOnAction(event -> {
                final ClipboardContent content = new ClipboardContent();
                content.putString(value.name());
                clipBoard.setContent(content);
            });
            weather.add(button);
        }
        weatherFlowPane.getChildren().addAll(weather);
        addFilter(weather,weatherSearch,weatherFlowPane);
    }

    /**
     * Add filter
     * @param buttons Button collection
     * @param textField TextField
     * @param owner FlowPane
     */
    private void addFilter(ObservableList<Button> buttons, TextField textField, FlowPane owner){
        FilteredList<Button> filteredList=new FilteredList<>(buttons, e->true);

        textField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.isEmpty()){
                filteredList.setPredicate(entity -> true);
                owner.getChildren().setAll(buttons);
            }
        });

        textField.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)){
                String text=textField.getText().toLowerCase();
                filteredList.setPredicate(button ->
                        button.getText().toLowerCase().contains(text)
                );

                SortedList<Button> sortedList=new SortedList<>(filteredList);
                owner.getChildren().setAll(sortedList);
            }
        });
    }
}
