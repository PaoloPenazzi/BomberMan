package it.unibo.bmbman.controller;
/**
 * runs the option menu.
 */
public interface OptionsMenuController {
    /**
     * call the right component, according to the option selected.
     * 
     * @param optionselected the selected option
     */
    void setOptionSelected(OptionsMenuList optionselected);
    /**
     * Used to get the SoundController.
     * @return {@link SoundsController}
     */
    SoundsController getSoundController();
}
