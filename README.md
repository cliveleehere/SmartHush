# Smart Hush

### My Idea
Taking care of a baby is hard work. There are a bevy of products designed to help parents and caregivers take care of their little ones. Some of these baby products are ‘smart.’  These ‘smart’ products pair some sort of a sensor and modulate its output or notifies the caregiver based on the input from the sensor. There are smart bassinets, thermometers, baby monitors, and strollers that all makes raising a baby slightly easier.

There are, however, no ‘smart’ white noise makers and apps on the market today. The existing white noise makers and apps do not modulate the noise based on the baby’s needs, and they also require the caregiver to stop the noise manually or input a set stop time. 

My idea is to create a smart white noise app for babies. It will use the microphone and/or the camera to sense whether the baby is sleeping or fussing, and either lower of turn up the volume and change the type of white noise.  If the baby is still crying after some preset time, or if the app detects that the baby needs attention, the app can notify a caregiver on another device.

### How I'll bring it to life

1) The sample code is in this repo: https://github.com/cliveleehere/SmartHush
It’s currently just reading the audio from the microphone and playing it back on the speakers.

2) I would appreciate Google’s help in obtaining the data to train a model. I am planning to train a custom model that’s part of the ML Kit, but I could use Google’s guidance on whether or not there’s another ML product I should use instead. Also, there doesn’t seem to be too many resources available on training models based on audio, so if Google has any additional resources for classifying audio, that would be great!

3) Rough timeline:
November & December - Create sample app with pluggable interfaces for input and output. Take some online courses on machine learning.
January & February - Obtain data & train model 
March - Integrate model to the app & iterate on model!
April - Polish! Add better UI!

### About me

I’m an android engineer by day. I work at Wayfair, and I work on the augmented reality / 3d team, and work with ARCore / Sceneform.  I also work on my personal apps by night.  My personal website is at https://cliveleehere.github.io/ , which lists some of my apps.