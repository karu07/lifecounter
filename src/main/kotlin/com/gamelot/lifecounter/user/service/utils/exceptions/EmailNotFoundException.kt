package com.gamelot.lifecounter.user.service.utils.exceptions

class EmailNotFoundException (email: String) : Exception("El email $email no ha sido encontrado")