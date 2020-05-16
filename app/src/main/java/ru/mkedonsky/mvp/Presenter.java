package ru.mkedonsky.mvp;

class Presenter {
    private final Model model;
    private final MainView view;

    Presenter(MainView view) {
        model = new Model();
        this.view = view;
    }


    void buttonClick(int index) {
        int newModelValue = model.getElementValueAtIndex(index) + 1;
        model.setElementValueAtIndex(index, newModelValue);
        if (view == null) return;
        view.setButtonText(index, newModelValue);
    }
}


