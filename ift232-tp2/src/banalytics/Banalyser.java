package banalytics;


/*
 * Classe qui sert à journaliser les événements qui surviennent durant l'utilisation d'un contenu
 * multimédia par un utilisateur. Une fois les événements correctement journalisés, il deviendra
 * possible d'analyser le comportement de l'utilisateur et d'en tirer des statistiques d'utilisation. 
 * 
 */

public class Banalyser {

	private Media media;
	private String type;

	private MediaLog log;

	private int etat;
	final static private int INITIAL = 1;
	final static private int PAUSED = 2;
	final static private int PLAYING = 3;
	final static private int STOPPED = 4;
	final static private int BUFFERING = 5;

	public Banalyser(Media m) {

		media = m;
		type = media.getType();
		etat = INITIAL;

	}

	public String getTextLog() {

		String res = "" + media;
		res += "\n" + log + "\n";
		return res;

	}

	public void start(int position) {

		if (etat == INITIAL) {
			if (type == Media.MUSIC) {
				log = new MusicLog();
				log.openPlaySegment(position);
				etat = PLAYING;
			}
			if (type == Media.VIDEO) {
				log = new VideoLog();
				log.openPlaySegment(position);
				etat = PLAYING;
			}
		} else if (etat == STOPPED) {
			if (type == Media.MUSIC) {
				log.openPlaySegment(position);
				etat = PLAYING;
			}
			if (type == Media.VIDEO) {
				log.openPlaySegment(position);
				etat = PLAYING;
			}
		}

	}

	public void stop(long position) {

		if (etat == PLAYING) {
			if (type == Media.MUSIC) {
				log.closePlaySegment(position);
				etat = STOPPED;
			}
			if (type == Media.VIDEO) {
				log.closePlaySegment(position);
				etat = STOPPED;
			}
		} else if (etat == PAUSED) {
			if (type == Media.MUSIC) {
				log.closePauseEntry(position);
				log.closePlaySegment(position);
				etat = STOPPED;
			}
			if (type == Media.VIDEO) {
				log.closePauseEntry(position);
				log.closePlaySegment(position);
				etat = STOPPED;
			}
		}

	}

	public void pause(long position) {

		if (etat == PLAYING) {
			if (type == Media.MUSIC) {
				log.openPauseEntry(position);
				etat = PAUSED;
			}
			if (type == Media.VIDEO) {
				log.openPauseEntry(position);
				etat = PAUSED;
			}
		}

	}

	public void resume(long time) {

		if (etat == PAUSED) {
			if (type == Media.MUSIC) {
				log.closePauseEntry(time);
				etat = PLAYING;
			}
			if (type == Media.VIDEO) {
				log.closePauseEntry(time);
				etat = PLAYING;
			}
		}

		else if (etat == BUFFERING) {
			if (type == Media.MUSIC) {
				log.closeBufferingEntry(time);
				etat = PLAYING;
			}
			if (type == Media.VIDEO) {
				log.closeBufferingEntry(time);
				etat = PLAYING;
			}
		}

	}

	public void move(long position) {

		if (etat == PLAYING) {
			if (type == Media.MUSIC) {
				log.addMoveEntry(position);
				log.openPauseEntry(position);
				etat = PAUSED;
			}
			if (type == Media.VIDEO) {
				log.addMoveEntry(position);
				log.openPauseEntry(position);
				etat = PAUSED;
			}
		} else if (etat == PAUSED) {
			if (type == Media.MUSIC) {
				log.addMoveEntry(position);

			}
			if (type == Media.VIDEO) {
				log.addMoveEntry(position);

			}
		}
	}

	public void buffer(long position) {

		if (etat == PLAYING) {
			if (type == Media.MUSIC) {
				log.openBufferingEntry(position);
				etat = BUFFERING;
			}
			if (type == Media.VIDEO) {
				log.openBufferingEntry(position);
				etat = BUFFERING;
			}
		}

	}

}
