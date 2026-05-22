package com.example.kumbarakala.data

import com.example.kumbarakala.R

object ProductCatalog {

    private const val UNSPLASH_PARAMS = "?auto=format&fit=crop&w=900&q=80"

    val products: List<Product> = listOf(
        Product(
            id = "curd-pot",
            name = "Curd Pot",
            category = Category.KITCHEN,
            tagline = "Sets perfect curd, every time",
            imageUrl = "https://images.unsplash.com/photo-1604264726154-26480e76f4e1$UNSPLASH_PARAMS",
            originStory = "Hand-thrown from river clay, fired in a traditional kiln for two days.",
            benefits = listOf(
                BenefitTemplate(
                    headline = "Naturally pH balanced",
                    body = "Clay's alkaline walls gently neutralise lactic acid, so the curd stays mild and never turns sour overnight.",
                    tagline = "No tang. Just creamy, set-just-right curd.",
                    kannadaHeadline = "ಸಹಜವಾಗಿಯೇ pH ಸಮತೋಲನ",
                    kannadaBody = "ಮಣ್ಣಿನ ಕ್ಷಾರೀಯ ಗೋಡೆಗಳು ಲ್ಯಾಕ್ಟಿಕ್ ಆಮ್ಲವನ್ನು ಮೃದುವಾಗಿ ತಟಸ್ಥಗೊಳಿಸುತ್ತವೆ; ಮೊಸರು ಸೌಮ್ಯವಾಗಿಯೇ ಇರುತ್ತದೆ, ರಾತ್ರಿಯಿಡೀ ಹುಳಿ ಆಗುವುದಿಲ್ಲ.",
                    kannadaTagline = "ಹುಳಿ ಇಲ್ಲ. ಗಟ್ಟಿಯಾಗಿ, ರುಚಿಯಾಗಿ ಮೊಸರು."
                ),
                BenefitTemplate(
                    headline = "Cultures stay alive",
                    body = "The micro-porous surface lets the curd breathe, keeping probiotic bacteria active far longer than steel or plastic.",
                    tagline = "Gut-friendly, the way grandmothers made it.",
                    kannadaHeadline = "ಜೀವಂತ ಸಂಸ್ಕೃತಿಗಳು",
                    kannadaBody = "ಸೂಕ್ಷ್ಮ ರಂಧ್ರಗಳ ಮೇಲ್ಮೈ ಮೊಸರಿಗೆ ಉಸಿರಾಡಲು ಬಿಡುತ್ತದೆ; ಪ್ರೋಬಯಾಟಿಕ್ ಬ್ಯಾಕ್ಟೀರಿಯಾ ಸ್ಟೀಲ್ ಅಥವಾ ಪ್ಲಾಸ್ಟಿಕ್‌ಗಿಂತ ಹೆಚ್ಚು ಸಮಯ ಸಕ್ರಿಯವಾಗಿರುತ್ತದೆ.",
                    kannadaTagline = "ಆರೋಗ್ಯಕರ ಜೀರ್ಣಕ್ರಿಯೆ — ಅಜ್ಜಿಯರ ರೀತಿ."
                ),
                BenefitTemplate(
                    headline = "Cools without a fridge",
                    body = "Evaporation through the pot walls keeps the curd 4 to 6 °C cooler than the room — fresh through the day.",
                    tagline = "Cool curd, no electricity.",
                    kannadaHeadline = "ಫ್ರಿಜ್ ಇಲ್ಲದೆ ತಂಪು",
                    kannadaBody = "ಮಡಕೆಯ ಗೋಡೆಗಳಿಂದ ಆವಿಯಾಗುವಿಕೆ ಮೊಸರನ್ನು ಕೋಣೆಗಿಂತ 4-6 °C ತಂಪಾಗಿಡುತ್ತದೆ — ದಿನವಿಡೀ ತಾಜಾ.",
                    kannadaTagline = "ತಂಪು ಮೊಸರು, ವಿದ್ಯುತ್ ಇಲ್ಲದೆ."
                )
            )
        ),
        Product(
            id = "water-pot",
            name = "Water Pot",
            category = Category.KITCHEN,
            tagline = "The original water cooler",
            imageUrl = "https://images.unsplash.com/photo-1590600504282-30e4dc6f8fcc$UNSPLASH_PARAMS",
            originStory = "Shaped on a kick-wheel, each pot takes about twenty minutes of patient turning.",
            benefits = listOf(
                BenefitTemplate(
                    headline = "Naturally cooled water",
                    body = "Tiny pores let moisture seep out and evaporate, dropping the water 8 to 10 °C below room temperature — gently, not shockingly.",
                    tagline = "Cool water that's kind to your throat.",
                    kannadaHeadline = "ಸಹಜವಾಗಿ ತಂಪಾದ ನೀರು",
                    kannadaBody = "ಸಣ್ಣ ರಂಧ್ರಗಳಿಂದ ತೇವಾಂಶ ಹೊರಬಂದು ಆವಿಯಾಗುತ್ತದೆ; ನೀರು ಕೋಣೆಯ ತಾಪಮಾನಕ್ಕಿಂತ 8-10 °C ಕಡಿಮೆ ಆಗುತ್ತದೆ — ನಿಧಾನವಾಗಿ, ಆಘಾತವಿಲ್ಲದೆ.",
                    kannadaTagline = "ಗಂಟಲಿಗೆ ಒಳಿತಾದ ತಂಪು ನೀರು."
                ),
                BenefitTemplate(
                    headline = "Alkaline & mineral-rich",
                    body = "Trace minerals from the earth raise the water's pH, helping balance the acidity of modern diets.",
                    tagline = "Earth's own filter.",
                    kannadaHeadline = "ಕ್ಷಾರೀಯ ಮತ್ತು ಖನಿಜ-ಸಮೃದ್ಧ",
                    kannadaBody = "ಭೂಮಿಯ ಸೂಕ್ಷ್ಮ ಖನಿಜಗಳು ನೀರಿನ pH ಹೆಚ್ಚಿಸುತ್ತವೆ; ಆಧುನಿಕ ಆಹಾರದ ಆಮ್ಲೀಯತೆಯನ್ನು ಸಮತೋಲನಗೊಳಿಸಲು ಸಹಾಯ ಮಾಡುತ್ತದೆ.",
                    kannadaTagline = "ಭೂಮಿಯ ಸಹಜ ಶುದ್ಧಿಕಾರಕ."
                ),
                BenefitTemplate(
                    headline = "Zero plastic. Zero toxins.",
                    body = "Unlike plastic, clay never leaches microplastics or BPA into your drinking water, even on the hottest day.",
                    tagline = "Pure water, pure earth.",
                    kannadaHeadline = "ಪ್ಲಾಸ್ಟಿಕ್ ಇಲ್ಲ. ವಿಷವಿಲ್ಲ.",
                    kannadaBody = "ಪ್ಲಾಸ್ಟಿಕ್‌ಗಿಂತ ಭಿನ್ನವಾಗಿ, ಮಣ್ಣು ಎಂದಿಗೂ ಮೈಕ್ರೋಪ್ಲಾಸ್ಟಿಕ್ ಅಥವಾ BPA ಅನ್ನು ಕುಡಿಯುವ ನೀರಿಗೆ ಸೇರಿಸುವುದಿಲ್ಲ — ಬೇಸಿಗೆಯಲ್ಲೂ.",
                    kannadaTagline = "ಶುದ್ಧ ನೀರು, ಶುದ್ಧ ಮಣ್ಣು."
                )
            )
        ),
        Product(
            id = "kulhad",
            name = "Tea Cup",
            category = Category.DRINKWARE,
            tagline = "The earthen chai cup",
            imageUrl = "https://images.unsplash.com/photo-1627834279031-55924de819b3$UNSPLASH_PARAMS",
            originStory = "Made by the thousand on village wheels, each one drying in the sun before its kiln journey.",
            benefits = listOf(
                BenefitTemplate(
                    headline = "Tastes like the soil",
                    body = "A faint earthy aroma lifts the flavour of chai in a way no ceramic cup can match.",
                    tagline = "Chai the way the village serves it.",
                    kannadaHeadline = "ಮಣ್ಣಿನ ರುಚಿ",
                    kannadaBody = "ಮೃದು ಮಣ್ಣಿನ ಸುಗಂಧವು ಚಹಾದ ರುಚಿಯನ್ನು ಎತ್ತುತ್ತದೆ — ಯಾವ ಸಿರಾಮಿಕ್ ಕಪ್ಪೂ ಈ ರುಚಿಯನ್ನು ನೀಡಲಾರದು.",
                    kannadaTagline = "ಹಳ್ಳಿಯಲ್ಲಿ ಕೊಡುವ ರೀತಿಯಲ್ಲಿ ಚಹಾ."
                ),
                BenefitTemplate(
                    headline = "Toxin-free, plastic-free",
                    body = "Unlike paper cups lined with plastic film, clay cups release nothing into your hot drink — just clean clay.",
                    tagline = "Sip without a side of plastic.",
                    kannadaHeadline = "ವಿಷ ಇಲ್ಲ, ಪ್ಲಾಸ್ಟಿಕ್ ಇಲ್ಲ",
                    kannadaBody = "ಪ್ಲಾಸ್ಟಿಕ್ ಲೇಪನವಿರುವ ಕಾಗದದ ಕಪ್‌ಗಳಂತೆಯಲ್ಲ — ಮಣ್ಣಿನ ಕಪ್‌ಗಳು ನಿಮ್ಮ ಬಿಸಿ ಪಾನೀಯಕ್ಕೆ ಏನನ್ನೂ ಬಿಡುಗಡೆ ಮಾಡುವುದಿಲ್ಲ.",
                    kannadaTagline = "ಪ್ಲಾಸ್ಟಿಕ್ ಇಲ್ಲದೆ ಕುಡಿಯಿರಿ."
                ),
                BenefitTemplate(
                    headline = "Returns to the earth",
                    body = "After use, the cup crushes back into soil within weeks. Zero waste, full circle.",
                    tagline = "Born from the earth, back to the earth.",
                    kannadaHeadline = "ಮತ್ತೆ ಮಣ್ಣಿಗೆ",
                    kannadaBody = "ಬಳಸಿದ ನಂತರ, ಕೆಲವೇ ವಾರಗಳಲ್ಲಿ ಕಪ್ ಮತ್ತೆ ಮಣ್ಣಾಗಿ ಮಿಶ್ರವಾಗುತ್ತದೆ. ಶೂನ್ಯ ತ್ಯಾಜ್ಯ, ಪೂರ್ಣ ಚಕ್ರ.",
                    kannadaTagline = "ಮಣ್ಣಿನಿಂದ ಹುಟ್ಟಿ, ಮಣ್ಣಿಗೇ ಮರಳುತ್ತದೆ."
                )
            )
        ),
        Product(
            id = "diya",
            name = "Oil Lamp",
            category = Category.LAMPS,
            tagline = "The lamp that lights every festival",
            imageUrl = "https://images.unsplash.com/photo-1759927576675-995b95ff53ed$UNSPLASH_PARAMS",
            originStory = "Pressed by hand from a single ball of clay, then sun-dried before firing.",
            benefits = listOf(
                BenefitTemplate(
                    headline = "Pure, soot-free flame",
                    body = "Clay holds the wick and oil steady so the flame burns clean — no harsh smoke like wax candles in plastic.",
                    tagline = "A clean light for sacred moments.",
                    kannadaHeadline = "ಶುದ್ಧ, ಹೊಗೆಯಿಲ್ಲದ ಜ್ಯೋತಿ",
                    kannadaBody = "ಮಣ್ಣು ಬತ್ತಿ ಮತ್ತು ಎಣ್ಣೆಯನ್ನು ಸ್ಥಿರವಾಗಿರಿಸುತ್ತದೆ; ಜ್ಯೋತಿ ಸ್ವಚ್ಛವಾಗಿ ಉರಿಯುತ್ತದೆ — ಪ್ಲಾಸ್ಟಿಕ್‌ನಲ್ಲಿರುವ ಮೇಣದ ಬತ್ತಿಗಳಂತೆ ಕಠೋರ ಹೊಗೆ ಇಲ್ಲ.",
                    kannadaTagline = "ಪವಿತ್ರ ಕ್ಷಣಗಳಿಗೆ ಶುದ್ಧ ಬೆಳಕು."
                ),
                BenefitTemplate(
                    headline = "Cool to touch, safe to hold",
                    body = "The thick clay walls insulate the flame, keeping the base cool enough for children's hands during pujas.",
                    tagline = "Safer than glass. Warmer than steel.",
                    kannadaHeadline = "ಸ್ಪರ್ಶಕ್ಕೆ ತಂಪು, ಹಿಡಿಯಲು ಸುರಕ್ಷಿತ",
                    kannadaBody = "ದಪ್ಪವಾದ ಮಣ್ಣಿನ ಗೋಡೆಗಳು ಜ್ಯೋತಿಯ ಶಾಖವನ್ನು ಒಳಗೇ ಹಿಡಿದಿಡುತ್ತವೆ; ಪೂಜೆಯ ಸಮಯದಲ್ಲಿ ಮಕ್ಕಳ ಕೈಗೂ ಸುರಕ್ಷಿತ.",
                    kannadaTagline = "ಗಾಜಿಗಿಂತ ಸುರಕ್ಷಿತ. ಸ್ಟೀಲ್‌ಗಿಂತ ಬೆಚ್ಚಗಿನ ಭಾವ."
                ),
                BenefitTemplate(
                    headline = "A festival without waste",
                    body = "One lamp can light a hundred Diwalis. When it finally chips, it returns to the soil.",
                    tagline = "Centuries-old tradition, zero landfill.",
                    kannadaHeadline = "ತ್ಯಾಜ್ಯವಿಲ್ಲದ ಹಬ್ಬ",
                    kannadaBody = "ಒಂದು ದೀಪವು ನೂರು ದೀಪಾವಳಿಗಳನ್ನು ಬೆಳಗಿಸಬಲ್ಲದು. ಒಡೆದಾಗ ಅದು ಮಣ್ಣಿಗೆ ಮರಳುತ್ತದೆ.",
                    kannadaTagline = "ಶತಮಾನಗಳ ಸಂಪ್ರದಾಯ, ಶೂನ್ಯ ತ್ಯಾಜ್ಯ."
                )
            )
        ),
        Product(
            id = "biryani-handi",
            name = "Biryani Pot",
            category = Category.COOKWARE,
            tagline = "The pot that makes dum",
            imageUrl = "https://images.unsplash.com/photo-1611013621103-91e10668a120$UNSPLASH_PARAMS",
            originStory = "Thick-walled and wide-bottomed, shaped for the slow magic of layered cooking.",
            benefits = listOf(
                BenefitTemplate(
                    headline = "Locks in dum aroma",
                    body = "Porous clay traps every drop of steam inside the lid, so the rice cooks in its own spice-laden vapour.",
                    tagline = "Every grain, fully flavoured.",
                    kannadaHeadline = "ದಮ್ ಸುಗಂಧ ಒಳಗೇ ಬಂಧಿತ",
                    kannadaBody = "ರಂಧ್ರಗಳಿರುವ ಮಣ್ಣು ಪ್ರತಿ ಆವಿಯ ಹನಿಯನ್ನು ಮುಚ್ಚಳದೊಳಗೇ ಹಿಡಿದಿಡುತ್ತದೆ; ಅನ್ನ ತನ್ನದೇ ಮಸಾಲೆಯ ಆವಿಯಲ್ಲಿ ಬೇಯುತ್ತದೆ.",
                    kannadaTagline = "ಪ್ರತಿ ಅಕ್ಕಿ ಕಾಳಿಗೂ ಪೂರ್ಣ ರುಚಿ."
                ),
                BenefitTemplate(
                    headline = "Gentle, even heat",
                    body = "Clay heats slowly and lets go slowly — no scorched bottoms, no half-cooked top layers.",
                    tagline = "Cooks the way grandmothers taught.",
                    kannadaHeadline = "ಸಮ, ಮೃದು ಶಾಖ",
                    kannadaBody = "ಮಣ್ಣು ನಿಧಾನವಾಗಿ ಬಿಸಿಯಾಗುತ್ತದೆ ಮತ್ತು ನಿಧಾನವಾಗಿ ತಣಿಯುತ್ತದೆ — ತಳ ಸುಡುವುದಿಲ್ಲ, ಮೇಲ್ಭಾಗ ಅರ್ಧ ಬೇಯುವುದಿಲ್ಲ.",
                    kannadaTagline = "ಅಜ್ಜಿಯರ ಬೋಧನೆಯ ರೀತಿಯಲ್ಲಿ ಬೇಯಿಸುತ್ತದೆ."
                ),
                BenefitTemplate(
                    headline = "Adds minerals, not chemicals",
                    body = "Unlike non-stick pans, clay leaches calcium, iron and phosphorus into the food — not Teflon.",
                    tagline = "Cookware that quietly nourishes.",
                    kannadaHeadline = "ಖನಿಜಗಳನ್ನು ಸೇರಿಸುತ್ತದೆ, ರಾಸಾಯನಿಕವಲ್ಲ",
                    kannadaBody = "ನಾನ್-ಸ್ಟಿಕ್ ಪಾತ್ರೆಗಳಂತಲ್ಲ — ಮಣ್ಣು ಆಹಾರಕ್ಕೆ ಕ್ಯಾಲ್ಸಿಯಂ, ಕಬ್ಬಿಣ ಮತ್ತು ಫಾಸ್ಫರಸ್ ಸೇರಿಸುತ್ತದೆ, ಟೆಫ್ಲಾನ್ ಅಲ್ಲ.",
                    kannadaTagline = "ಸದ್ದಿಲ್ಲದೆ ಪೋಷಿಸುವ ಪಾಕಶಾಲೆ."
                )
            )
        ),
        Product(
            id = "clay-tawa",
            name = "Clay Griddle",
            category = Category.COOKWARE,
            tagline = "Rotis the way they're meant to be",
            imageUrl = "https://images.unsplash.com/photo-1763951719324-d1ff7eff0f7b$UNSPLASH_PARAMS",
            imageResId = R.drawable.mitti_tawa,
            originStory = "Slow-fired flat clay disc, seasoned with mustard oil before its first roti.",
            benefits = listOf(
                BenefitTemplate(
                    headline = "Zero non-stick chemicals",
                    body = "No PTFE, no PFOA. Just seasoned clay that releases the roti naturally once it's ready.",
                    tagline = "Healthy cooking, the way it always was.",
                    kannadaHeadline = "ನಾನ್-ಸ್ಟಿಕ್ ರಾಸಾಯನಿಕಗಳಿಲ್ಲ",
                    kannadaBody = "PTFE ಇಲ್ಲ, PFOA ಇಲ್ಲ. ಕೇವಲ ಎಣ್ಣೆಯಲ್ಲಿ ಸಂಸ್ಕರಿಸಿದ ಮಣ್ಣು — ರೊಟ್ಟಿ ಬೆಂದ ಮೇಲೆ ಸಹಜವಾಗಿಯೇ ಬಿಡುತ್ತದೆ.",
                    kannadaTagline = "ಆರೋಗ್ಯಕರ ಅಡುಗೆ, ಎಂದಿನಂತೆ."
                ),
                BenefitTemplate(
                    headline = "Even, gentle browning",
                    body = "Clay distributes heat evenly across the surface, so rotis puff up without scorched spots.",
                    tagline = "Softer rotis, every single one.",
                    kannadaHeadline = "ಸಮ, ಮೃದು ಬಣ್ಣ",
                    kannadaBody = "ಮಣ್ಣು ಶಾಖವನ್ನು ಮೇಲ್ಮೈಯಾದ್ಯಂತ ಸಮವಾಗಿ ಹಂಚುತ್ತದೆ; ರೊಟ್ಟಿ ಸುಡದೆ ಚೆನ್ನಾಗಿ ಉಬ್ಬುತ್ತದೆ.",
                    kannadaTagline = "ಪ್ರತಿ ರೊಟ್ಟಿಯೂ ಮೃದು."
                ),
                BenefitTemplate(
                    headline = "Keeps food alkaline",
                    body = "Cooking on clay preserves the food's natural pH — unlike aluminium, which can leach into acidic dishes.",
                    tagline = "Kinder on the stomach.",
                    kannadaHeadline = "ಆಹಾರವನ್ನು ಕ್ಷಾರೀಯವಾಗಿ ಇಡುತ್ತದೆ",
                    kannadaBody = "ಮಣ್ಣಿನ ಮೇಲೆ ಬೇಯಿಸುವುದು ಆಹಾರದ ಸಹಜ pH ಅನ್ನು ಉಳಿಸಿಕೊಳ್ಳುತ್ತದೆ — ಅಲ್ಯೂಮಿನಿಯಂನಂತೆಯಲ್ಲ, ಆಮ್ಲೀಯ ಪಾಕಗಳಿಗೆ ಲೋಹ ಬೆರೆಯುವುದಿಲ್ಲ.",
                    kannadaTagline = "ಹೊಟ್ಟೆಗೆ ಒಳಿತು."
                )
            )
        ),
        Product(
            id = "earthen-bottle",
            name = "Water Bottle",
            category = Category.DRINKWARE,
            tagline = "The water bottle of summer",
            imageUrl = "https://images.unsplash.com/photo-1644328986176-0d2d6af69314$UNSPLASH_PARAMS",
            originStory = "Long-necked and narrow-mouthed, shaped to keep heat out and freshness in.",
            benefits = listOf(
                BenefitTemplate(
                    headline = "Cools as you carry",
                    body = "The narrow neck slows evaporation just enough — the body of the bottle keeps water 6 to 8 °C cool through the day.",
                    tagline = "The original travel bottle.",
                    kannadaHeadline = "ಸಾಗಿಸುತ್ತಲೇ ತಂಪು",
                    kannadaBody = "ಕಿರಿದಾದ ಕುತ್ತಿಗೆ ಆವಿಯಾಗುವಿಕೆಯನ್ನು ಸಾಕಷ್ಟು ನಿಧಾನಗೊಳಿಸುತ್ತದೆ — ಬಾಟಲಿಯು ನೀರನ್ನು ದಿನವಿಡೀ 6-8 °C ತಂಪಾಗಿಡುತ್ತದೆ.",
                    kannadaTagline = "ಮೂಲ ಪ್ರಯಾಣದ ಬಾಟಲಿ."
                ),
                BenefitTemplate(
                    headline = "Mineral-balanced water",
                    body = "Clay subtly raises the water's pH and adds trace minerals — making each sip more hydrating.",
                    tagline = "Hydration, the earth's way.",
                    kannadaHeadline = "ಖನಿಜ-ಸಮತೋಲಿತ ನೀರು",
                    kannadaBody = "ಮಣ್ಣು ಮೃದುವಾಗಿ ನೀರಿನ pH ಹೆಚ್ಚಿಸುತ್ತದೆ ಮತ್ತು ಸೂಕ್ಷ್ಮ ಖನಿಜಗಳನ್ನು ಸೇರಿಸುತ್ತದೆ — ಪ್ರತಿ ಗುಟುಕು ಹೆಚ್ಚು ಹಿತಕರ.",
                    kannadaTagline = "ಭೂಮಿಯ ರೀತಿಯಲ್ಲಿ ಜಲಸಂಚಯ."
                ),
                BenefitTemplate(
                    headline = "Plastic-free for life",
                    body = "Refill, reuse, last for years — without a single microplastic entering your water.",
                    tagline = "One bottle. A lifetime of pure water.",
                    kannadaHeadline = "ಜೀವಮಾನಪರ್ಯಂತ ಪ್ಲಾಸ್ಟಿಕ್ ಮುಕ್ತ",
                    kannadaBody = "ಮತ್ತೆ ತುಂಬಿಸಿ, ಮತ್ತೆ ಬಳಸಿ, ವರ್ಷಗಳ ಕಾಲ ಬಾಳಿಕೆ — ನೀರಿಗೆ ಒಂದು ಮೈಕ್ರೋಪ್ಲಾಸ್ಟಿಕ್ ಸಹ ಸೇರುವುದಿಲ್ಲ.",
                    kannadaTagline = "ಒಂದು ಬಾಟಲಿ. ಜೀವಮಾನದ ಶುದ್ಧ ನೀರು."
                )
            )
        ),
        Product(
            id = "decor-vase",
            name = "Hand-Thrown Vase",
            category = Category.DECOR,
            tagline = "A quiet centrepiece",
            imageUrl = "https://images.unsplash.com/photo-1520408222757-6f9f95d87d5d$UNSPLASH_PARAMS",
            originStory = "Pulled tall on the wheel, each one slightly different — the mark of the maker's hand.",
            benefits = listOf(
                BenefitTemplate(
                    headline = "One of one",
                    body = "No two are identical. Every curve is shaped by the potter's fingers, not a factory mould.",
                    tagline = "Owning a piece of someone's hands.",
                    kannadaHeadline = "ಪ್ರತಿಯೊಂದೂ ವಿಶಿಷ್ಟ",
                    kannadaBody = "ಎರಡು ಒಂದೇ ರೀತಿಯವಲ್ಲ. ಪ್ರತಿ ತಿರುವನ್ನು ಕುಂಬಾರನ ಬೆರಳುಗಳು ರೂಪಿಸುತ್ತವೆ, ಕಾರ್ಖಾನೆಯ ಅಚ್ಚಲ್ಲ.",
                    kannadaTagline = "ಯಾರೋ ಒಬ್ಬರ ಕೈಗಳ ಒಂದು ಭಾಗವನ್ನು ಹೊಂದಿರುವುದು."
                ),
                BenefitTemplate(
                    headline = "Honest materials",
                    body = "Local clay, natural mineral glaze, wood-fired kiln. Nothing else.",
                    tagline = "Decor that respects the earth.",
                    kannadaHeadline = "ಪ್ರಾಮಾಣಿಕ ಸಾಮಗ್ರಿಗಳು",
                    kannadaBody = "ಸ್ಥಳೀಯ ಮಣ್ಣು, ನೈಸರ್ಗಿಕ ಖನಿಜ ಲೇಪನ, ಕಟ್ಟಿಗೆಯಲ್ಲಿ ಸುಟ್ಟ ಕುಂಬ — ಇನ್ನೇನೂ ಇಲ್ಲ.",
                    kannadaTagline = "ಭೂಮಿಯನ್ನು ಗೌರವಿಸುವ ಅಲಂಕಾರ."
                ),
                BenefitTemplate(
                    headline = "Supports village craft",
                    body = "Each vase keeps a wheel spinning, a kiln burning, and a centuries-old skill alive.",
                    tagline = "Beautiful at home. Vital for a village.",
                    kannadaHeadline = "ಹಳ್ಳಿಯ ಕಲೆಗೆ ಬೆಂಬಲ",
                    kannadaBody = "ಪ್ರತಿ ಹೂಜಿಯೂ ಒಂದು ಚಕ್ರವನ್ನು ತಿರುಗಿಸುತ್ತದೆ, ಒಂದು ಕುಂಬವನ್ನು ಉರಿಸುತ್ತದೆ, ಶತಮಾನಗಳ ಕೌಶಲ್ಯವನ್ನು ಉಳಿಸುತ್ತದೆ.",
                    kannadaTagline = "ಮನೆಗೆ ಸುಂದರ. ಹಳ್ಳಿಗೆ ಜೀವನಾಧಾರ."
                )
            )
        ),
        Product(
            id = "planter",
            name = "Terracotta Planter",
            category = Category.GARDEN,
            tagline = "Where roots breathe",
            imageUrl = "https://images.unsplash.com/photo-1620293106076-ad27d651efe3$UNSPLASH_PARAMS",
            originStory = "Unglazed, low-fired, and left to breathe — exactly as plants need.",
            benefits = listOf(
                BenefitTemplate(
                    headline = "Roots that breathe",
                    body = "Porous clay walls let oxygen reach the root zone — no suffocation, no root rot.",
                    tagline = "Plants thrive, naturally.",
                    kannadaHeadline = "ಉಸಿರಾಡುವ ಬೇರುಗಳು",
                    kannadaBody = "ರಂಧ್ರಗಳಿರುವ ಮಣ್ಣಿನ ಗೋಡೆಗಳು ಬೇರಿನ ವಲಯಕ್ಕೆ ಆಮ್ಲಜನಕವನ್ನು ತಲುಪಿಸುತ್ತವೆ — ಉಸಿರುಗಟ್ಟುವಿಕೆ ಇಲ್ಲ, ಬೇರು ಕೊಳೆಯುವುದಿಲ್ಲ.",
                    kannadaTagline = "ಗಿಡಗಳು ಸಹಜವಾಗಿಯೇ ಬೆಳೆಯುತ್ತವೆ."
                ),
                BenefitTemplate(
                    headline = "Self-regulating moisture",
                    body = "Clay wicks excess water away after rain and releases it back when the soil dries — like a slow drip system, free.",
                    tagline = "Less watering. Happier plants.",
                    kannadaHeadline = "ತಾನೇ ತೇವಾಂಶ ನಿಯಂತ್ರಿಸುತ್ತದೆ",
                    kannadaBody = "ಮಣ್ಣು ಮಳೆಯ ನಂತರ ಹೆಚ್ಚಿನ ನೀರನ್ನು ಹೀರಿಕೊಂಡು, ಮಣ್ಣು ಒಣಗಿದಾಗ ಹಿಂದಿರುಗಿಸುತ್ತದೆ — ಉಚಿತ ನಿಧಾನಗತಿಯ ಹನಿ ನೀರಾವರಿಯಂತೆ.",
                    kannadaTagline = "ಕಡಿಮೆ ನೀರು ಹಾಕಿ. ಗಿಡಗಳಿಗೆ ಸಂತೋಷ."
                ),
                BenefitTemplate(
                    headline = "Cools the root zone",
                    body = "On a 40 °C balcony, the inside of a clay pot stays markedly cooler — protecting tender roots.",
                    tagline = "Shade for the soil.",
                    kannadaHeadline = "ಬೇರಿನ ವಲಯವನ್ನು ತಂಪಾಗಿಸುತ್ತದೆ",
                    kannadaBody = "40 °C ಬಾಲ್ಕನಿಯಲ್ಲೂ ಮಣ್ಣಿನ ಮಡಕೆಯ ಒಳಭಾಗ ಸ್ಪಷ್ಟವಾಗಿ ತಂಪಾಗಿರುತ್ತದೆ — ನವಿರಾದ ಬೇರುಗಳನ್ನು ರಕ್ಷಿಸುತ್ತದೆ.",
                    kannadaTagline = "ಮಣ್ಣಿಗೆ ನೆರಳು."
                )
            )
        ),
        Product(
            id = "storage-jar",
            name = "Storage Jar",
            category = Category.STORAGE,
            tagline = "Keeps grain like grandmother did",
            imageUrl = "https://images.unsplash.com/photo-1719173150322-e75de9901efb$UNSPLASH_PARAMS",
            originStory = "Wide-bellied and tight-mouthed — built for monsoons, lentils, and patience.",
            benefits = listOf(
                BenefitTemplate(
                    headline = "Grains that don't sweat",
                    body = "Clay regulates humidity inside the jar, so rice, dal and atta stay dry and pest-free without chemicals.",
                    tagline = "Better than airtight steel.",
                    kannadaHeadline = "ಬೆವರಿಸದ ಧಾನ್ಯಗಳು",
                    kannadaBody = "ಮಣ್ಣು ಜಾಡಿಯೊಳಗಿನ ತೇವಾಂಶವನ್ನು ನಿಯಂತ್ರಿಸುತ್ತದೆ; ರಾಸಾಯನಿಕವಿಲ್ಲದೆ ಅಕ್ಕಿ, ಬೇಳೆ, ಹಿಟ್ಟು ಒಣವಾಗಿ ಮತ್ತು ಕೀಟಮುಕ್ತವಾಗಿ ಇರುತ್ತದೆ.",
                    kannadaTagline = "ಗಾಳಿನಿರೋಧಕ ಸ್ಟೀಲ್‌ಗಿಂತ ಉತ್ತಮ."
                ),
                BenefitTemplate(
                    headline = "Naturally pest-resistant",
                    body = "The earthy environment discourages weevils and grain moths — no neem leaves needed.",
                    tagline = "A pantry without poison.",
                    kannadaHeadline = "ಸಹಜವಾಗಿಯೇ ಕೀಟ ನಿರೋಧಕ",
                    kannadaBody = "ಮಣ್ಣಿನ ವಾತಾವರಣ ಕೀಟಗಳನ್ನು ಮತ್ತು ಧಾನ್ಯದ ಪತಂಗಗಳನ್ನು ತಡೆಯುತ್ತದೆ — ಬೇವಿನ ಎಲೆಗಳ ಅಗತ್ಯವಿಲ್ಲ.",
                    kannadaTagline = "ವಿಷವಿಲ್ಲದ ಭಂಡಾರ."
                ),
                BenefitTemplate(
                    headline = "Built to outlast a generation",
                    body = "Properly fired clay storage jars survive decades of monsoons. Many families pass them down.",
                    tagline = "Heirloom storage, not landfill.",
                    kannadaHeadline = "ಒಂದು ಪೀಳಿಗೆಗೂ ಮೀರಿ ಬಾಳುತ್ತದೆ",
                    kannadaBody = "ಸರಿಯಾಗಿ ಸುಟ್ಟ ಮಣ್ಣಿನ ಜಾಡಿಗಳು ದಶಕಗಳ ಮಳೆಗಾಲಗಳನ್ನು ತಡೆದುಕೊಳ್ಳುತ್ತವೆ. ಅನೇಕ ಕುಟುಂಬಗಳು ಇವನ್ನು ಮುಂದಿನ ಪೀಳಿಗೆಗೆ ನೀಡುತ್ತವೆ.",
                    kannadaTagline = "ವಂಶಪಾರಂಪರ್ಯ ಭಂಡಾರ, ತ್ಯಾಜ್ಯವಲ್ಲ."
                )
            )
        ),
        Product(
            id = "ritual-bowl",
            name = "Ritual Bowl",
            category = Category.DECOR,
            tagline = "For aartis and offerings",
            imageUrl = "https://images.unsplash.com/photo-1644329099968-615bd5631d9a$UNSPLASH_PARAMS",
            originStory = "Shallow and steady, weighted at the base so it holds firm during prayers.",
            benefits = listOf(
                BenefitTemplate(
                    headline = "Sacred, by tradition",
                    body = "Earthenware is the original material of ritual — used in temples long before brass or silver.",
                    tagline = "Pure clay for pure intent.",
                    kannadaHeadline = "ಪರಂಪರೆಯಿಂದ ಪವಿತ್ರ",
                    kannadaBody = "ಮಣ್ಣಿನ ಪಾತ್ರೆಗಳು ಆಚರಣೆಯ ಮೂಲ ಸಾಮಗ್ರಿ — ಹಿತ್ತಾಳೆ ಅಥವಾ ಬೆಳ್ಳಿಗೆ ಬಹಳ ಮುಂಚೆಯೇ ದೇವಾಲಯಗಳಲ್ಲಿ ಬಳಸಲಾಗುತ್ತಿತ್ತು.",
                    kannadaTagline = "ಶುದ್ಧ ಭಾವಕ್ಕೆ ಶುದ್ಧ ಮಣ್ಣು."
                ),
                BenefitTemplate(
                    headline = "Cool to the touch",
                    body = "Even with a lit camphor or aarti flame inside, the rim stays cool enough to hold safely.",
                    tagline = "Safer prayers, every time.",
                    kannadaHeadline = "ಸ್ಪರ್ಶಕ್ಕೆ ತಂಪು",
                    kannadaBody = "ಒಳಗೆ ಹಚ್ಚಿದ ಕರ್ಪೂರ ಅಥವಾ ಆರತಿ ಜ್ಯೋತಿ ಇದ್ದರೂ ಬಟ್ಟಲಿನ ಅಂಚು ಹಿಡಿಯಲು ತಂಪಾಗಿಯೇ ಇರುತ್ತದೆ.",
                    kannadaTagline = "ಪ್ರತಿ ಬಾರಿಯೂ ಸುರಕ್ಷಿತ ಪ್ರಾರ್ಥನೆ."
                ),
                BenefitTemplate(
                    headline = "Made by hand, blessed by intent",
                    body = "Each bowl carries the rhythm of the wheel and the patience of the potter — a fitting vessel for offerings.",
                    tagline = "Devotion held in clay.",
                    kannadaHeadline = "ಕೈಯಿಂದ ಸಿದ್ಧ, ಭಾವದಿಂದ ಪವಿತ್ರ",
                    kannadaBody = "ಪ್ರತಿ ಬಟ್ಟಲೂ ಚಕ್ರದ ಲಯ ಮತ್ತು ಕುಂಬಾರನ ತಾಳ್ಮೆಯನ್ನು ಹೊತ್ತಿರುತ್ತದೆ — ನೈವೇದ್ಯಕ್ಕೆ ಯೋಗ್ಯ ಪಾತ್ರೆ.",
                    kannadaTagline = "ಮಣ್ಣಿನಲ್ಲಿ ಬಂಧಿಯಾದ ಭಕ್ತಿ."
                )
            )
        ),
        Product(
            id = "incense-holder",
            name = "Incense Holder",
            category = Category.LAMPS,
            tagline = "Where fragrance meets earth",
            imageUrl = "https://images.unsplash.com/photo-1667031232692-7e1cee98f977$UNSPLASH_PARAMS",
            originStory = "Small, slow-fired pieces — often the apprentice's first wheel-thrown work.",
            benefits = listOf(
                BenefitTemplate(
                    headline = "Catches every ember",
                    body = "Heat-tested clay safely cradles burning agarbatti and dhoop — no scorched tables, no fire risk.",
                    tagline = "Safe enough for the prayer corner.",
                    kannadaHeadline = "ಪ್ರತಿ ಕೆಂಡವನ್ನೂ ಹಿಡಿಯುತ್ತದೆ",
                    kannadaBody = "ಶಾಖ-ಪರೀಕ್ಷಿತ ಮಣ್ಣು ಉರಿಯುತ್ತಿರುವ ಅಗರಬತ್ತಿ ಮತ್ತು ಧೂಪವನ್ನು ಸುರಕ್ಷಿತವಾಗಿ ಹಿಡಿದಿಡುತ್ತದೆ — ಮೇಜು ಸುಡುವುದಿಲ್ಲ, ಬೆಂಕಿಯ ಅಪಾಯವಿಲ್ಲ.",
                    kannadaTagline = "ಪೂಜಾ ಮೂಲೆಗೆ ಸುರಕ್ಷಿತ."
                ),
                BenefitTemplate(
                    headline = "Holds aroma longer",
                    body = "Porous clay subtly absorbs and re-releases fragrance — the room stays gently scented hours after the stick burns out.",
                    tagline = "Aromatherapy, the earthen way.",
                    kannadaHeadline = "ಸುಗಂಧ ದೀರ್ಘಕಾಲ ಉಳಿಯುತ್ತದೆ",
                    kannadaBody = "ರಂಧ್ರಗಳಿರುವ ಮಣ್ಣು ಸುಗಂಧವನ್ನು ಮೃದುವಾಗಿ ಹೀರಿ ಪುನಃ ಬಿಡುತ್ತದೆ — ಬತ್ತಿ ಮುಗಿದ ಗಂಟೆಗಳ ನಂತರವೂ ಕೋಣೆ ಸುಗಂಧಭರಿತವಾಗಿರುತ್ತದೆ.",
                    kannadaTagline = "ಮಣ್ಣಿನ ರೀತಿಯ ಅರೋಮಾಥೆರಪಿ."
                ),
                BenefitTemplate(
                    headline = "Tiny piece, real craft",
                    body = "Even the smallest holder is wheel-thrown — a complete piece of pottery in your hand.",
                    tagline = "Craft you can hold between two fingers.",
                    kannadaHeadline = "ಸಣ್ಣ ತುಣುಕು, ನಿಜ ಕಲೆ",
                    kannadaBody = "ಚಿಕ್ಕದಾದ ಹಿಡಿಕೆಯೂ ಚಕ್ರದ ಮೇಲೆ ರೂಪಗೊಂಡಿದೆ — ನಿಮ್ಮ ಕೈಯಲ್ಲಿ ಪೂರ್ಣ ಕುಂಬಾರಿಕೆಯ ಒಂದು ತುಣುಕು.",
                    kannadaTagline = "ಎರಡು ಬೆರಳುಗಳ ನಡುವೆ ಹಿಡಿಯಬಹುದಾದ ಕಲೆ."
                )
            )
        )
    )

    fun byId(id: String): Product? = products.firstOrNull { it.id == id }
}
