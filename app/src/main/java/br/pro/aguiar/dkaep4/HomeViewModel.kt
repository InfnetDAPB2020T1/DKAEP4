package br.pro.aguiar.dkaep4

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.pro.aguiar.dkaep4.model.Filme

class HomeViewModel : ViewModel() {
    var filme = MutableLiveData<Filme?>().apply{
        this.value = null
    }
}