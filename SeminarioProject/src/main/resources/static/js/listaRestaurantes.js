const container = document.getElementById("cardsContainer");

const giftCards = {
    1: {
        nombre: "Dominos Pizza",
        ruta_imagen: "img/restaurantes/dominos_social_logo.jpg",
        descuento: 0
    },

    2: {
        nombre: "El corral",
        ruta_imagen: "img/restaurantes/el_corral.jpg",
        descuento: 1
    },

    3: {
        nombre: "Subway",
        ruta_imagen: "img/restaurantes/Subway-Logo.png",
        descuento: 0
    },

    4: {
        nombre: "Dominos Pizza",
        ruta_imagen: "img/restaurantes/dominos_social_logo.jpg",
        descuento: 0
    },

    5: {
        nombre: "El corral",
        ruta_imagen: "img/restaurantes/el_corral.jpg",
        descuento: 1
    },

    6: {
        nombre: "Subway",
        ruta_imagen: "img/restaurantes/Subway-Logo.png",
        descuento: 0
    },

    
    7: {
        nombre: "Dominos Pizza",
        ruta_imagen: "img/restaurantes/dominos_social_logo.jpg",
        descuento: 0
    },

    8: {
        nombre: "El corral",
        ruta_imagen: "img/restaurantes/el_corral.jpg",
        descuento: 1
    },

    9: {
        nombre: "Subway",
        ruta_imagen: "img/restaurantes/Subway-Logo.png",
        descuento: 0
    }
}

let giftCardHTML;


const sortGiftCards = () => {
    for (let key in giftCards) {
        giftCardHTML = `
            <article class="mt-12 mx-auto hover:scale-105">
                <button id="${key}" onclick="location.href='';">
                    <img src="${giftCards[key].ruta_imagen}" alt="Imagen de la tarjeta" id="giftCardImage"
                    class="w-56 h-36 rounded-2xl object-cover" />
                </button>
                <h2 class="mt-2 text-lg text-center"> ${giftCards[key].nombre} </h2>
            </article>
        `;

        container.innerHTML += giftCardHTML;
    }
}

sortGiftCards();