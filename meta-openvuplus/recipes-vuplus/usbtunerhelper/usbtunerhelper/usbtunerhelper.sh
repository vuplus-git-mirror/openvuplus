#!/bin/sh

if ! [ -x /usr/bin/usbtunerhelper ]; then
	exit 0
fi

VTUNER_FILE="/tmp/.vtuner_available"

case "$1" in
	start)
		start-stop-daemon -S -x /usr/bin/usbtunerhelper
		if [ -f $VTUNER_FILE ]
		then
			echo "[USBTUNERHELPER] wait for initializing vtuner"
			while [ ! -f $VTUNER_FILE ]; do
				usleep 100000
			done
			sleep 2
		fi
		;;
	stop)
		start-stop-daemon -K -x /usr/bin/usbtunerhelper
		;;
	restart|reload)
		$0 stop
		$0 start
		;;
	*)
		echo "Usage: $0 {start|stop|restart}"
		exit 1
		;;
esac

exit 0
