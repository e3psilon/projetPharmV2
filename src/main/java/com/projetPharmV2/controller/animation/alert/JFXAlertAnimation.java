package com.projetPharmV2.controller.animation.alert;




import javafx.animation.Animation;
import javafx.animation.Transition;
import javafx.scene.Node;

/**
 * JFXAlertAnimation object is used to to create showing/hiding animation for
 * {@link JFXAlert} control
 *
 * @author Shadi Shaheen
 * @version 1.0
 * @since 2017-05-26
 */
public interface JFXAlertAnimation {

    public void initAnimation(Node contentContainer, Node overlay);

    public Animation createShowingAnimation(Node contentContainer, Node overlay);

    public Animation createHidingAnimation(Node contentContainer, Node overlay);

    public static JFXAlertAnimation LEFT_ANIMATION = new JFXAlertAnimation() {
        @Override
        public void initAnimation(Node contentContainer, Node overlay) {
            overlay.setOpacity(0);
            contentContainer.setTranslateX(-(contentContainer.getLayoutX()
                                             + contentContainer.getLayoutBounds().getMaxX()));
        }

        @Override
        public Animation createShowingAnimation(Node contentContainer, Node overlay) {
            return new HorizontalTransition(true, contentContainer, overlay);
        }

        @Override
        public Animation createHidingAnimation(Node contentContainer, Node overlay) {
            return inverseAnimation(new HorizontalTransition(true, contentContainer, overlay));
        }
    };

    public static JFXAlertAnimation RIGHT_ANIMATION = new JFXAlertAnimation() {
        @Override
        public void initAnimation(Node contentContainer, Node overlay) {
            overlay.setOpacity(0);
            contentContainer.setTranslateX(contentContainer.getLayoutX()
                                           + contentContainer.getLayoutBounds().getMaxX());
        }

        @Override
        public Animation createShowingAnimation(Node contentContainer, Node overlay) {
            return new HorizontalTransition(false, contentContainer, overlay);
        }

        @Override
        public Animation createHidingAnimation(Node contentContainer, Node overlay) {
            return inverseAnimation(new HorizontalTransition(false, contentContainer, overlay));
        }
    };

    public static JFXAlertAnimation TOP_ANIMATION = new JFXAlertAnimation() {
        @Override
        public void initAnimation(Node contentContainer, Node overlay) {
            overlay.setOpacity(0);
            contentContainer.setTranslateY(-(contentContainer.getLayoutY()
                                             + contentContainer.getLayoutBounds().getMaxY()));
        }

        @Override
        public Animation createShowingAnimation(Node contentContainer, Node overlay) {
            return new VerticalTransition(true, contentContainer, overlay);
        }

        @Override
        public Animation createHidingAnimation(Node contentContainer, Node overlay) {
            return inverseAnimation(new VerticalTransition(true, contentContainer, overlay));
        }
    };

    public static JFXAlertAnimation BOTTOM_ANIMATION = new JFXAlertAnimation() {
        @Override
        public void initAnimation(Node contentContainer, Node overlay) {
            overlay.setOpacity(0);
            contentContainer.setTranslateY(contentContainer.getLayoutY()
                                           + contentContainer.getLayoutBounds().getMaxY());
        }

        @Override
        public Animation createShowingAnimation(Node contentContainer, Node overlay) {
            return new VerticalTransition(false, contentContainer, overlay);
        }

        @Override
        public Animation createHidingAnimation(Node contentContainer, Node overlay) {
            return inverseAnimation(new VerticalTransition(false, contentContainer, overlay));
        }
    };

    public static JFXAlertAnimation CENTER_ANIMATION = new JFXAlertAnimation() {
        @Override
        public void initAnimation(Node contentContainer, Node overlay) {
            overlay.setOpacity(0);
            contentContainer.setScaleX(0);
            contentContainer.setScaleY(0);
        }

        @Override
        public Animation createShowingAnimation(Node contentContainer, Node overlay) {
            return new CenterTransition(contentContainer, overlay);
        }

        @Override
        public Animation createHidingAnimation(Node contentContainer, Node overlay) {
            return inverseAnimation(new CenterTransition(contentContainer, overlay));
        }
    };

    static Transition inverseAnimation(Transition centerTransition) {
        centerTransition.jumpTo(centerTransition.getCycleDuration());
        centerTransition.setRate(-1);
        return centerTransition;
    }

}
