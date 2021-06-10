function search() {
    var search_txt = document.getElementById('search_txt');
    var className = document.getElementById('search_txt').className;
    
    if(className == 'search_txt on'){
        search_txt.classList.remove('on');
    }else{
        search_txt.classList.add('on');
    }
}