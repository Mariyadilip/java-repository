package pattern.creation.abstractfactory;

interface AbstractWidgetFactory {

 Window createWindow();
 Scroll createScroll();
 Button[] createNavigationButtons();
 
}
