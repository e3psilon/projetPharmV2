package com.projetPharmV2.controller.event;



import com.jfoenix.controls.JFXDialog;
import javafx.event.Event;
import javafx.event.EventType;

/**
 * JFXDialog events, used exclusively by the following methods:
 * <ul>
 * <li>{@link JFXDialog#close()}
 * <li>{@link JFXDialog#getShowAnimation()}
 * </ul>
 *
 * @author Shadi Shaheen
 * @version 1.0
 * @since 2016-03-09
 */
public class JFXDialogEvent extends Event {

    private static final long serialVersionUID = 1L;

    /**
     * Construct a new JFXDialog {@code Event} with the specified event type
     *
     * @param eventType the event type
     */
    public JFXDialogEvent(EventType<? extends Event> eventType) {
        super(eventType);
    }

    /**
     * This event occurs when a JFXDialog is closed, no longer visible to the user
     * ( after the exit animation ends )
     */
    public static final EventType<JFXDialogEvent> CLOSED =
        new EventType<>(Event.ANY, "DIALOG_CLOSED");

    /**
     * This event occurs when a JFXDialog is opened, visible to the user
     * ( after the entrance animation ends )
     */
    public static final EventType<JFXDialogEvent> OPENED =
        new EventType<>(Event.ANY, "DIALOG_OPENED");


}
