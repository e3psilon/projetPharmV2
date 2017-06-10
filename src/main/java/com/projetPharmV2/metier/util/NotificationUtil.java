package com.projetPharmV2.metier.util;

import javafx.scene.control.Alert.AlertType;
import javafx.util.Duration;

public class NotificationUtil {

	/**
	 * Fonction qui retoune une notification d'erreur mot de passe incorrect
	 *
	 */
	public static void NotificationMotDePasseIncorrect() {
		NotificationType notificationType = NotificationType.ERROR;
		TrayNotification tray = new TrayNotification();
		tray.setTitle(AttributUtil.INFORMATION_INCORRECTE);
		tray.setMessage(AttributUtil.EMAIL_OU_MOT_DE_PASSE_INCORRECT);
		tray.setAnimationType(AnimationType.POPUP);
		tray.setNotificationType(notificationType);
		tray.showAndDismiss(Duration.millis(3000));
	}

	/**
	 * Fonction qui retourne une Notification Connexion
	 */
	public static void NotificationValidAndConnexion() {
		NotificationType notificationType = NotificationType.SUCCESS;
		TrayNotification tray = new TrayNotification();
		tray.setTitle(AttributUtil.INFORMATION_CORRECTE);
		tray.setMessage(AttributUtil.EMAIL_OU_MOT_DE_PASSE_CORRECT);
		tray.setNotificationType(notificationType);
		tray.showAndDismiss(Duration.millis(3000));
	}

	public static void NotificationChampObligatoire() {
		NotificationType notificationType = NotificationType.ERROR;
		TrayNotification tray = new TrayNotification();
		tray.setTitle(AttributUtil.CHAMPS_OBLIGATOIRE);
		tray.setMessage(AttributUtil.LE_CHAMP_NOM_UTILISATEUR_ET_OU_MOT_DE_PASSE_EST_OBLIGATOIRE);
		tray.setAnimationType(AnimationType.POPUP);
		tray.setNotificationType(notificationType);
		tray.showAndDismiss(Duration.millis(3000));
	}
	public static void NotificationTousChampObligatoire() {
		NotificationType notificationType = NotificationType.ERROR;
		TrayNotification tray = new TrayNotification();
		tray.setTitle(AttributUtil.CHAMPS_OBLIGATOIRE);
		tray.setMessage(AttributUtil.TOUS_LES_CHAMPS_OBLIGATOIRE);
		tray.setAnimationType(AnimationType.POPUP);
		tray.setNotificationType(notificationType);
		tray.showAndDismiss(Duration.millis(3000));
	}

	public static void MotdePasseEtConfirmationIncorrect() {
		NotificationType notificationType = NotificationType.WARNING;
		TrayNotification tray = new TrayNotification();
		tray.setTitle(AttributUtil.CHAMPS_OBLIGATOIRE);
		tray.setMessage(AttributUtil.MOT_DE_PASSE_ET_CONIRMATION_INCORECT);
		tray.setAnimationType(AnimationType.POPUP);
		tray.setNotificationType(notificationType);
		tray.showAndDismiss(Duration.millis(3000));

	}

	public static void NotificationInscriptionOK() {
		NotificationType notificationType = NotificationType.SUCCESS;
		TrayNotification tray = new TrayNotification();
		tray.setTitle(AttributUtil.INSCRIPTION);
		tray.setMessage(AttributUtil.VOTRE_USER_EST_SAUVE);
		tray.setNotificationType(notificationType);
		tray.showAndDismiss(Duration.millis(3000));
	}

	public static void NotificationERRORInatendue() {
		NotificationType notificationType = NotificationType.ERROR;
		TrayNotification tray = new TrayNotification();
		tray.setTitle(AttributUtil.ERREUR_INATENDUE);
		tray.setMessage(AttributUtil.MESSAGE_ERREUR);
		tray.setAnimationType(AnimationType.POPUP);
		tray.setNotificationType(notificationType);
		tray.showAndDismiss(Duration.millis(3000));
	}

	public static void NotificationERROR(String title,String message) {
		NotificationType notificationType = NotificationType.ERROR;
		TrayNotification tray = new TrayNotification();
		tray.setTitle(title);
		tray.setMessage(message);
		tray.setAnimationType(AnimationType.POPUP);
		tray.setNotificationType(notificationType);
		tray.showAndDismiss(Duration.millis(3000));
	}
	public static void alert(AlertType alertType,String title,String message) {
		javafx.scene.control.Alert alert = new javafx.scene.control.Alert(alertType);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(message);
		alert.showAndWait();
	}
}
