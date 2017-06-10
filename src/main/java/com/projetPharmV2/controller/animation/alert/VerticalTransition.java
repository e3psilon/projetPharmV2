package com.projetPharmV2.controller.animation.alert;




import com.jfoenix.transitions.CachedTransition;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.util.Duration;

/**
 * Vertical translate animation for {@link JFXAlert} control
 *
 * @author Shadi Shaheen
 * @version 1.0
 * @since 2017-05-26
 */
public class VerticalTransition extends CachedTransition {
    public VerticalTransition(boolean topDirection, Node contentContainer, Node overlay) {
        super(contentContainer, new Timeline(
            new KeyFrame(Duration.ZERO,
                new KeyValue(contentContainer.translateYProperty(),
                    (contentContainer.getLayoutY() + contentContainer.getLayoutBounds().getMaxY())
                    * (topDirection? -1 : 1), Interpolator.LINEAR),
                new KeyValue(overlay.opacityProperty(), 0, Interpolator.EASE_BOTH)
            ),
            new KeyFrame(Duration.millis(1000),
                new KeyValue(overlay.opacityProperty(), 1, Interpolator.EASE_BOTH),
                new KeyValue(contentContainer.translateYProperty(), 0, Interpolator.EASE_OUT)
            )));
        // reduce the number to increase the shifting , increase number to reduce shifting
        setCycleDuration(Duration.seconds(0.4));
        setDelay(Duration.seconds(0));
    }
}
